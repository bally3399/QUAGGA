package africa.semicolon.com.quagga.security.config.services;

import africa.semicolon.com.quagga.data.models.User;
import africa.semicolon.com.quagga.security.config.model.SecureUser;
import africa.semicolon.com.quagga.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userServices;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try{

            User user = userServices.getUserByUsername(username);
            return new SecureUser(user);
        }catch (RuntimeException runtimeException){
            throw new UsernameNotFoundException(runtimeException.getMessage());
        }
    }
}
