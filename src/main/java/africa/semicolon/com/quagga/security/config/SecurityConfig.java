package africa.semicolon.com.quagga.security.config;

import africa.semicolon.com.quagga.security.config.filter.CustomAuthorizationFilter;
import africa.semicolon.com.quagga.security.config.filter.CustomUsernamePasswordAuthenticationFilter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import static org.springframework.http.HttpMethod.POST;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@AllArgsConstructor
public class SecurityConfig {
    private final AuthenticationManager authenticationManager;
    private final CustomAuthorizationFilter authorizationFilter;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        var   authFilter = new CustomUsernamePasswordAuthenticationFilter(authenticationManager) ;
        authFilter.setFilterProcessesUrl("/api/v1/auth");
        return httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .sessionManagement(c-> c.sessionCreationPolicy(STATELESS))
                .addFilterAt(authFilter, BasicAuthenticationFilter.class)
                .addFilterBefore(authorizationFilter, CustomUsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(c->c.requestMatchers(POST, "/api/v1/auth").permitAll()
                        .requestMatchers( "/api/v1/media").hasAuthority("USER"))

                .build();
    }
}
