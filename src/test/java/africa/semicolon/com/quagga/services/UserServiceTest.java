package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.Role;
import africa.semicolon.com.quagga.dtos.request.RegisterUserRequest;
import africa.semicolon.com.quagga.dtos.Response.RegisterUserResponse;
import africa.semicolon.com.quagga.dtos.request.RegisterRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    public UserService userService;

    @Test
    public void testRegisterUser(){
        RegisterRequest request = new RegisterRequest();
        request.setFirstName("username");
        request.setLastName("lastname");
        request.setPassword("password");
        request.setEmail("username@gmail.com");
        request.setAddress("No 30, Helen Street, Idumota, Lagos");
        request.setPhoneNumber("08123456789");
        request.setRole(Role.CLIENT);
        RegisterUserResponse response = userService.register(request);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Registration successful");
    }



}
