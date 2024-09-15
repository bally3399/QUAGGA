package africa.semicolon.com.quagga.services;
import africa.semicolon.com.quagga.data.models.Client;
import africa.semicolon.com.quagga.data.models.Role;
import africa.semicolon.com.quagga.data.models.Specialist;
import africa.semicolon.com.quagga.data.models.User;
import africa.semicolon.com.quagga.dtos.request.LoginRequest;
import africa.semicolon.com.quagga.dtos.request.LogoutRequest;
import africa.semicolon.com.quagga.dtos.request.RegisterRequest;
import africa.semicolon.com.quagga.dtos.request.UpdateClientRequest;
import africa.semicolon.com.quagga.dtos.response.*;
import org.apache.http.auth.InvalidCredentialsException;
import org.springframework.http.ResponseEntity;
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

    LoginResponse login(LoginRequest loginRequest);

    Client findClientById(Long id);

    List<Client> findAllClient();

    Specialist findSpecialistById(Long id);

    List<Specialist> getAllSpecialists();

    DeleteUserResponse deleteSpecialistById(Long id);

    DeleteUserResponse deleteClientById(long id);

    User save(User user);

    void deleteAll();

    LogoutResponse logout(LogoutRequest logoutRequest);

    List<Specialist> findAllSpecialist();

    List<User> findUserByCategory(Role category);
}
