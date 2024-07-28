package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.dtos.request.RegisterRequest;
import africa.semicolon.com.quagga.dtos.response.RegisterSpecialistResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static africa.semicolon.com.quagga.data.models.Role.SPECIALIST;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SpecialistServicesImplTest {
    @Autowired
    private SpecialistService specialistService;

    @Test
    public void registerSpecialistTest() {
        RegisterRequest request = new RegisterRequest();
        request.setFirstName("Sulaiman");
        request.setLastName("Baliqis");
        request.setEmail("sulaimabaliqis@gmail.com");
        request.setPassword("123456");
        request.setAddress("sabo yaba");
        request.setRole(SPECIALIST);
        request.setCompanyName("Semicolon");
        request.setCompanyRegNo("abcd");
        request.setUsername("bally");
        request.setProfessionalSkills("Construction");
        RegisterSpecialistResponse response = specialistService.registerSpecialist(request);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Specialist registered successfully");

    }
}