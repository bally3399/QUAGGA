package africa.semicolon.com.quagga.services;


import africa.semicolon.com.quagga.data.models.User;
import africa.semicolon.com.quagga.dtos.request.RegisterRequest;
import africa.semicolon.com.quagga.dtos.request.RegisterUserRequest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import africa.semicolon.com.quagga.dtos.response.RegisterUserResponse;

import java.util.List;

public interface UserService {
    RegisterUserResponse register(RegisterRequest request);
    User getById(long id);
    User getUserByUsername(String username) throws UsernameNotFoundException;
    List<User> findAllUsers();
    List<User> getAllSpecialist();
    List<User> getAllSupplier();

}
