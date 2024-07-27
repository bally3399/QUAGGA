package africa.semicolon.com.quagga.services;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    public UserService userService;

    @Test
    public void testRegisterUser(){
        CreateUserRequest request = new CreateUserRequest();
        request.setEmail("DummyTwoEmail@gmail.com");
        request.setPassword("password");
        request.setFirstName("Dummy");
        request.setLastName("Two");

        CreateUserResponse response = userService.register(request);
        assertThat(response).isNotNull();
        assertTrue(response.getMessage().contains("Registration successful"));
    }

}
