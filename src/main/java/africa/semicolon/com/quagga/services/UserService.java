package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.User;
import africa.semicolon.com.quagga.dtos.Request.LoginRequest;
import africa.semicolon.com.quagga.dtos.Response.LoginResponse;
import africa.semicolon.com.quagga.dtos.request.RegisterRequest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import africa.semicolon.com.quagga.dtos.response.RegisterResponse;

import java.util.List;

public interface UserService {
    RegisterResponse register(RegisterRequest request);
    User getById(long id);

<<<<<<< HEAD
    User getUserByUsername(String username) throws UsernameNotFoundException;

    List<User> findAllUsers();

    List<User> getAllSpecialist();

    List<User> getAllSupplier();
=======
    User save(User user);

    UpdateClientResponse update(UpdateClientRequest updateClientRequest);

    void deleteById(long id);
>>>>>>> 1bfd79603e763307856fb2bd3a0b6afc3503f657
}
