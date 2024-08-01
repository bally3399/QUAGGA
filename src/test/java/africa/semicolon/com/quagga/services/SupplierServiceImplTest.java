package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.dtos.request.RegisterRequest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static africa.semicolon.com.quagga.data.models.Role.SUPPLIER;
import africa.semicolon.com.quagga.dtos.response.RegisterResponse;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
@SpringBootTest
class SupplierServiceImplTest {
    @Autowired
    private UserService userService;

    @Test
    void createSupplier() {
        RegisterRequest request = new RegisterRequest();
        request.setFirstName("John");
        request.setLastName("Doe");
        request.setPassword("password");
        request.setEmail("johndbeloved@gmail.com");
        request.setAddress("No 30, Helen Street, Idumota, Lagos");
        request.setPhoneNumber("08123456789");
        request.setRole(SUPPLIER);
        RegisterResponse response = userService.register(request);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Registration successful");

    }
}