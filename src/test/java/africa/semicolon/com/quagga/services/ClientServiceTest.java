package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.Role;
import africa.semicolon.com.quagga.data.models.User;
import africa.semicolon.com.quagga.dtos.response.RegisterUserResponse;
import africa.semicolon.com.quagga.dtos.request.RegisterRequest;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ClientServiceTest {

    @Autowired
    public UserService userService;

    @Test
    public void testRegisterClient(){
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

    @Test
    @DisplayName("Test that user can be retrieved by id")
    public void testGetUserById() {
        User user = userService.getById(1L);
        assertThat(user).isNotNull();
        assertThat(user.getId()).isEqualTo(1L);
        System.out.println(user.getFirstName());
    }


}
