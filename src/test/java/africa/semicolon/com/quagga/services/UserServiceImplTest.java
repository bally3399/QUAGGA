package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.Role;
import africa.semicolon.com.quagga.dtos.request.RegisterRequest;
import africa.semicolon.com.quagga.dtos.request.UpdateRequest;
import africa.semicolon.com.quagga.dtos.response.RegisterResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserService userService;


    @Test
    void testUserCanUpdateProfile(){
            RegisterRequest request = new RegisterRequest();
            request.setFirstName("username");
            request.setLastName("lastname");
            request.setPassword("password");
            request.setEmail("username@gmail.com");
            request.setAddress("No 30, Helen Street, Idumota, Lagos");
            request.setPhoneNumber("08123456789");
            request.setRole(Role.SUPPLIER);
            RegisterResponse response = userService.register(request);
            assertThat(response).isNotNull();
            assertThat(response.getMessage()).isEqualTo("Registration successful");
            UpdateRequest update = new UpdateRequest();
            update.setAddress("new address");
            update.setFirstName("John");
            update.setLastName("Sam");


    }

}