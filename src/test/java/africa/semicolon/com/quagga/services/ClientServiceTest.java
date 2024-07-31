package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.Role;
import africa.semicolon.com.quagga.data.models.Specialist;
import africa.semicolon.com.quagga.data.models.User;
import africa.semicolon.com.quagga.dtos.response.RegisterUserResponse;
import africa.semicolon.com.quagga.dtos.request.RegisterRequest;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Sql(scripts = {"/db/data.sql"})
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
        User user = userService.getById(100L);
        assertThat(user).isNotNull();
        assertThat(user.getId()).isEqualTo(100L);
        assertThat(user.getFirstName()).isEqualTo("john");
    }

    @Test
    public void testFindAllSpecialist(){
        List<User> specialistList = userService.getAllSupplier();
        assertThat(specialistList.size()).isEqualTo(4L);
    }


}
