package africa.semicolon.com.quagga.services;


import africa.semicolon.com.quagga.data.models.User;
import africa.semicolon.com.quagga.dtos.request.RegisterRequest;
import africa.semicolon.com.quagga.dtos.request.RegisterUserRequest;
import africa.semicolon.com.quagga.dtos.Response.RegisterUserResponse;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService {
    RegisterUserResponse register(RegisterRequest request);

    User getUserByUsername(String username) throws UsernameNotFoundException;
}
