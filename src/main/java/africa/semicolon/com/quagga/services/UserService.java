package africa.semicolon.com.quagga.services;
import africa.semicolon.com.quagga.data.models.Client;
import africa.semicolon.com.quagga.data.models.Specialist;
import africa.semicolon.com.quagga.data.models.User;
import africa.semicolon.com.quagga.dtos.request.LoginRequest;
import africa.semicolon.com.quagga.dtos.request.RegisterRequest;
import africa.semicolon.com.quagga.dtos.request.UpdateClientRequest;
import africa.semicolon.com.quagga.dtos.response.DeleteUserResponse;
import africa.semicolon.com.quagga.dtos.response.LoginResponse;
import africa.semicolon.com.quagga.dtos.response.UpdateClientResponse;
import africa.semicolon.com.quagga.dtos.response.RegisterResponse;
import org.apache.http.auth.InvalidCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService {
    RegisterResponse register(RegisterRequest request);
    User getById(long id);
    User getUserByUsername(String username) throws UsernameNotFoundException;
    List<User> findAllUsers();
    List<User> getAllSpecialist();
    List<User> getAllSupplier();

    UpdateClientResponse update(UpdateClientRequest updateClientRequest);

    DeleteUserResponse deleteById(long id);
    User findUserById(Long id);

    LoginResponse login(LoginRequest loginRequest) throws InvalidCredentialsException;

    Client findClientById(Long id);

    List<Client> findAllClient();

    Specialist findSpecialistById(Long id);
}
