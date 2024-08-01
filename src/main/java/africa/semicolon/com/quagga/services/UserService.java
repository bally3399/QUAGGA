package africa.semicolon.com.quagga.services;
import africa.semicolon.com.quagga.data.models.User;
import africa.semicolon.com.quagga.dtos.request.RegisterRequest;
import africa.semicolon.com.quagga.dtos.response.RegisterUserResponse;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService {
    RegisterUserResponse register(RegisterRequest request);
    User getById(long id);
    User getUserByUsername(String username) throws UsernameNotFoundException;
}
