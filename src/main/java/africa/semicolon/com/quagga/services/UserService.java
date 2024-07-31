package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.User;
import africa.semicolon.com.quagga.dtos.Request.LoginRequest;
import africa.semicolon.com.quagga.dtos.Response.LoginResponse;
import africa.semicolon.com.quagga.dtos.request.RegisterRequest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import africa.semicolon.com.quagga.dtos.response.RegisterResponse;

public interface UserService {
    RegisterResponse register(RegisterRequest request);
    User getById(long id);

    User getUserByUsername(String username) throws UsernameNotFoundException;

}
