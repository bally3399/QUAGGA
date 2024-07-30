package africa.semicolon.com.quagga.services;


import africa.semicolon.com.quagga.data.models.User;
import africa.semicolon.com.quagga.dtos.request.RegisterRequest;
import africa.semicolon.com.quagga.dtos.request.RegisterUserRequest;
import africa.semicolon.com.quagga.dtos.response.RegisterUserResponse;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import africa.semicolon.com.quagga.dtos.response.RegisterUserResponse;

public interface UserService {
    RegisterUserResponse register(RegisterRequest request);

    User getUserByUsername(String username) throws UsernameNotFoundException;
}
