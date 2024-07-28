package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.Specialist;
import africa.semicolon.com.quagga.dtos.request.RegisterRequest;
import africa.semicolon.com.quagga.dtos.response.RegisterSpecialistResponse;
import africa.semicolon.com.quagga.exceptions.IncorrectPasswordException;
import africa.semicolon.com.quagga.exceptions.UserAlreadyExistException;
import africa.semicolon.com.quagga.repository.SpecialistRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SpecialistServicesImpl implements SpecialistService{
    private final ModelMapper modelMapper;
    private final SpecialistRepository specialistRepository;
    private final UserService userService;
    @Override
    public RegisterSpecialistResponse registerSpecialist(RegisterRequest request) {
        String email = request.getEmail().toLowerCase();
        validate(email);
        validateRegistration(request);
        userService.register(request);
        Specialist specialist = modelMapper.map(request, Specialist.class);
        specialist = specialistRepository.save(specialist);
        var response = modelMapper.map(specialist, RegisterSpecialistResponse.class);
        response.setMessage("Specialist registered successfully");
        return response;
    }
    private void validate(String email) {
        for (Specialist specialist : specialistRepository.findAll()) {
            if (specialist.getUser().getEmail().equals(email.toLowerCase())) {
                throw new UserAlreadyExistException("email already exist");
            }
        }
    }
    private static void validateRegistration(RegisterRequest request) {
        if (!request.getEmail().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) throw new UserAlreadyExistException("Invalid Input");
        if (request.getPassword().isEmpty()) throw new IncorrectPasswordException("Invalid Password provide a Password");
    }

}
