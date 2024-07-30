package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.Specialist;
import africa.semicolon.com.quagga.data.models.User;
import africa.semicolon.com.quagga.dtos.request.RegisterRequest;
import africa.semicolon.com.quagga.dtos.response.RegisterSpecialistResponse;
import africa.semicolon.com.quagga.repository.SpecialistRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SpecialistServicesImpl implements SpecialistService {
    private final ModelMapper modelMapper;
    private final SpecialistRepository specialistRepository;
    private final UserService userService;

    @Override
    public RegisterSpecialistResponse registerSpecialist(RegisterRequest request) {
        userService.register(request);
        Specialist specialist = modelMapper.map(request, Specialist.class);
        specialist = specialistRepository.save(specialist);
        var response = modelMapper.map(specialist, RegisterSpecialistResponse.class);
        response.setMessage("Specialist registered successfully");
        return response;
    }

    @Override
    public void createSpecialist(User savedUser) {

    }
}
