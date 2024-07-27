package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.dtos.request.RegisterSpecialistRequest;
import africa.semicolon.com.quagga.dtos.response.RegisterSpecialistResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static africa.semicolon.com.quagga.models.Role.SPECIALIST;
@SpringBootTest
public class SpecialistServicesImplTest {
    @Autowired
    private SpecialistService specialistService;

    @Test
    public void registerSpecialistTest() {
        RegisterSpecialistRequest request = new RegisterSpecialistRequest();
        request.setFirstName("Sulaiman");
        request.setLastName("Baliqis");
        request.setEmail("sulaimabaliqis@gmail.com");
        request.setPassword("123456");
        request.setAddress("sabo yaba");
        request.setComment("I love the work");
        request.setRole(SPECIALIST);
        request.setRating(2);
        request.setCompanyName("Semicolon");
        request.setCompanyRegNo("abcd");
        request.setUsername("bally");
        request.setProfessionalSkills("Construction");
        RegisterSpecialistResponse response = specialistService.registerSpecialist(request);


    }
}