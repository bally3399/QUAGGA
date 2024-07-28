package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.User;
import africa.semicolon.com.quagga.data.repositories.UserRepository;
import africa.semicolon.com.quagga.dtos.Request.RegisterUserRequest;
import africa.semicolon.com.quagga.dtos.Response.RegisterUserResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository){
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }
    @Override
    public RegisterUserResponse register(RegisterUserRequest request) {
        User newUser = modelMapper.map(request, User.class);
        User savedUser = userRepository.save(newUser);
        RegisterUserResponse response = modelMapper.map(savedUser, RegisterUserResponse.class);
        response.setMessage("Registration successful");
        return response;
    }


}
