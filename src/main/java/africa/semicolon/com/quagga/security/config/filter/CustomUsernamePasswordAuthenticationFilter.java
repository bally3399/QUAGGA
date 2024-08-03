package africa.semicolon.com.quagga.security.config.filter;

import africa.semicolon.com.quagga.dtos.request.LoginRequest;
import africa.semicolon.com.quagga.dtos.Response.BaseResponse;
import africa.semicolon.com.quagga.dtos.Response.LoginResponse;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.util.Collection;

@RequiredArgsConstructor
public class CustomUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Authentication attemptAuthentication (HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        try{
            InputStream requestBodyStream = request.getInputStream();
            LoginRequest loginRequest = objectMapper.readValue(requestBodyStream, LoginRequest.class);
            var authResult = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
                    SecurityContextHolder.getContext().setAuthentication(authResult);
            return authResult;

        }
        catch (IOException e){
            throw new BadCredentialsException(e.getMessage());
        }

    }


    @Override
    protected void  successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException{
        LoginResponse loginResponse = new LoginResponse();
        String token = generateAccessToken(authResult);
        loginResponse.setToken(token);
        loginResponse.setMessage("Successful Authentication");
        BaseResponse <LoginResponse> authResponse = new BaseResponse<>();
        authResponse.setCode(HttpStatus.OK.value());
        authResponse.setData(loginResponse);
        authResponse.setStatus(true);
        response.getOutputStream().write(objectMapper.writeValueAsBytes(authResponse));
        response.flushBuffer();
        chain.doFilter(request, response);

    }




    private  static String generateAccessToken(Authentication authResult){
        return JWT.create()
                .withIssuer("quagga")
                .withArrayClaim("roles", getClaimsForm(authResult.getAuthorities()))
                .withExpiresAt(Instant.now().plusSeconds(24*60*60))
                .sign(Algorithm.HMAC512("secret"));
    }


    private static String[] getClaimsForm(Collection<? extends GrantedAuthority> authorities) {
        return authorities.stream()
                .map(GrantedAuthority::getAuthority)
                .toArray(String[]::new);

    }

    @Override

    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setMessage(exception.getMessage());
        BaseResponse<LoginResponse> baseResponse = new BaseResponse<>();
        baseResponse.setData(loginResponse);
        baseResponse.setStatus(false);
        baseResponse.setCode(HttpStatus.UNAUTHORIZED.value());
        response.getOutputStream()
                .write(objectMapper.writeValueAsBytes(baseResponse));
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.flushBuffer();

    }

}
