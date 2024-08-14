package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.User;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService{

//    private final UserService userService;
//    private final PasswordEncoder passwordEncoder;

    @Override
    public boolean authenticate(String username, String password) {
//        User user = userService.getUserByUsername(username);
//        return validatePassword(password, user.getPassword());
        return false;
    }

/*
    private boolean validatePassword(String password, String encryptedPassword) {
        return passwordEncoder.matches(password, encryptedPassword);
    }
*/



}

