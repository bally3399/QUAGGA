package africa.semicolon.com.quagga.services;
import africa.semicolon.com.quagga.data.models.User;
import africa.semicolon.com.quagga.dtos.request.RegisterRequest;
import africa.semicolon.com.quagga.dtos.request.UpdateClientRequest;
import africa.semicolon.com.quagga.dtos.response.RegisterResponse;
import africa.semicolon.com.quagga.dtos.response.UpdateClientResponse;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import africa.semicolon.com.quagga.dtos.request.UpdateRequest;
import africa.semicolon.com.quagga.dtos.response.UpdateResponse;

import java.util.List;

public interface UserService {
    RegisterResponse register(RegisterRequest request);
    User getById(long id);
    User getUserByUsername(String username) throws UsernameNotFoundException;
    List<User> findAllUsers();
    List<User> getAllSpecialist();
    List<User> getAllSupplier();

    UpdateResponse update(UpdateRequest updateRequest);

    UpdateClientResponse update(UpdateClientRequest updateClientRequest);

    void deleteById(long id);
}
