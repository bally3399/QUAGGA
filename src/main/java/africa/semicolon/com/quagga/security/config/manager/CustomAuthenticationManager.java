package africa.semicolon.com.quagga.security.config.manager;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationManager implements AuthenticationManager {

   private final AuthenticationProvider authenticationProvider;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
         Class<? extends Authentication> authenticationType = authentication.getClass();
         if(authenticationProvider.supports(authenticationType)){
             return authenticationProvider.authenticate(authentication);
         }
         throw new BadCredentialsException("Bad credentials");
    }
}
