package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.dtos.request.RegisterRequest;
import africa.semicolon.com.quagga.dtos.request.UpdateSpecialistRequest;
import africa.semicolon.com.quagga.dtos.response.RegisterResponse;
import africa.semicolon.com.quagga.dtos.response.UpdateSpecialistResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static africa.semicolon.com.quagga.data.models.Role.SPECIALIST;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class SpecialistServicesImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void testThatSpecialistCanBeCreated() {
        RegisterRequest request = new RegisterRequest();
        request.setFirstName("Sulaiman");
        request.setLastName("Baliqis");
        request.setEmail("sulaimabaliqis@gmail.com");
        request.setPhoneNumber("09132431343");
        request.setPassword("123456");
        request.setAddress("sabo yaba");
        request.setRole(SPECIALIST);
        request.setCompanyName("Semicolon");
        request.setCompanyRegNo("abcd");
        request.setProfessionalSkills(List.of("Construction", "Painting"));
        RegisterResponse response = userService.register(request);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Registration successful");

    }

    @Test
    public void testThatSpecialistCanUpdateDetails(){
        RegisterRequest request = new RegisterRequest();
        request.setFirstName("Sulaiman");
        request.setLastName("Baliqis");
        request.setEmail("sulaimabaliqis@gmail.com");
        request.setPhoneNumber("09132431343");
        request.setPassword("123456");
        request.setAddress("sabo yaba");
        request.setRole(SPECIALIST);
        request.setCompanyName("Semicolon");
        request.setCompanyRegNo("abcd");
        request.setProfessionalSkills(List.of("Construction", "Painting"));
        RegisterResponse response = userService.register(request);

        UpdateSpecialistRequest updateSpecialistRequest = new UpdateSpecialistRequest();
        updateSpecialistRequest.setFirstName("Sulaiman2");
        updateSpecialistRequest.setLastName("Baliqis2");
        updateSpecialistRequest.setEmail("sulaimabaliqis2@gmail.com");
        updateSpecialistRequest.setPhoneNumber("09132431343");
        updateSpecialistRequest.setPassword("123456");
        updateSpecialistRequest.setAddress("sabo yaba");
        updateSpecialistRequest.setCompanyName("Semicolon africa");
        updateSpecialistRequest.setCompanyRegNo("abcdef");
        UpdateSpecialistResponse response1 = userService.update(updateSpecialistRequest);


    }

}