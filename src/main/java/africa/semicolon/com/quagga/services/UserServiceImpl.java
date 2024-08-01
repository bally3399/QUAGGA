package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.Role;
import africa.semicolon.com.quagga.data.models.User;
import africa.semicolon.com.quagga.data.repositories.UserRepository;
import africa.semicolon.com.quagga.dtos.request.RegisterRequest;
import africa.semicolon.com.quagga.dtos.response.RegisterResponse;
import africa.semicolon.com.quagga.exceptions.UserNotFoundException;
import africa.semicolon.com.quagga.exceptions.IncorrectPasswordException;
import africa.semicolon.com.quagga.exceptions.UserAlreadyExistException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final ClientService clientService;
    private final SpecialistService specialistService;
    private final SupplierService supplierService;
    private final ProfessionalService professionalService;
    private final AdminService adminService;

    @Override
    public africa.semicolon.com.quagga.dtos.response.RegisterResponse register(RegisterRequest request) {
        String email = request.getEmail().toLowerCase();
        validate(email);
        validateRegistration(request);
        User newUser = modelMapper.map(request, User.class);
        User savedUser = userRepository.save(newUser);

        switch (savedUser.getRole()) {
            case SPECIALIST -> specialistService.createSpecialist(savedUser, request);
            case ADMIN -> adminService.createAdmin(savedUser, request);
            case CLIENT -> clientService.createClient(savedUser);
            case SUPPLIER -> supplierService.createSupplier(savedUser, request);
            case PROFESSIONAL -> professionalService.createProfessional(savedUser);
        }

        RegisterResponse response = modelMapper.map(savedUser, africa.semicolon.com.quagga.dtos.response.RegisterResponse.class);
        response.setMessage("Registration successful");
        return response;
    }

    @Override
    public User getById(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User does not exist"));

   
    }

    @Override
    public User getUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(()->new UserNotFoundException("User not found"));
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getAllSpecialist() {
        List<User> userList = userRepository.findAll();
        List<User> specialists = new ArrayList<>();
        for (User user : userList) {
            if (user.getRole().equals(Role.SPECIALIST)){
                specialists.add(user);
            }
        }
        return specialists;
    }



    @Override
    public List<User> getAllSupplier() {
        List<User> userList = userRepository.findAll();
        List<User> suppliers = new ArrayList<>();
        for (User user : userList) {
            if (user.getRole().equals(Role.SUPPLIER)){
                suppliers.add(user);
            }
        }
        return suppliers;
    }

    private void validate(String email) {
        for (User user : userRepository.findAll()) {
            if (user.getEmail().equals(email.toLowerCase())) {
                throw new UserAlreadyExistException("email already exist");
            }
        }
    }
    private static void validateRegistration(RegisterRequest request) {
        if (!request.getEmail().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) throw new UserAlreadyExistException("Invalid Input");
        if (request.getPassword().isEmpty()) throw new IncorrectPasswordException("Invalid Password provide a Password");
    }



}
