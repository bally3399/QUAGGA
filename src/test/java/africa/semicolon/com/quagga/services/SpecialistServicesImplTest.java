package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.dtos.request.RegisterRequest;
import africa.semicolon.com.quagga.dtos.request.UpdateRequest;
import africa.semicolon.com.quagga.dtos.response.RegisterResponse;
import africa.semicolon.com.quagga.dtos.response.UpdateResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static africa.semicolon.com.quagga.data.models.Role.SPECIALIST;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class SpecialistServicesImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void testThatSpecialistCanBeCreated() {
        RegisterRequest request = new RegisterRequest();
        request.setFirstName("Jay");
        request.setLastName("Cee");
        request.setEmail("cee@gmail.com");
        request.setPhoneNumber("09132431343");
        request.setPassword("123456");
        request.setAddress("sabo yaba");
        request.setRole(SPECIALIST);
        request.setCompanyName("Semicolon");
        request.setCompanyRegNo("abcd");
//        request.setProfessionalSkills(List.of("Construction", "Painting"));
        RegisterResponse response = userService.register(request);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Registration successful");

    }

//    @Test
//    public void testThatSpecialistCanUpdateDetails(){
//        UpdateRequest updateRequest = new UpdateRequest();
//        updateRequest.setFirstName("Sulaiman2");
//        updateRequest.setLastName("Baliqis2");
//        updateRequest.setEmail("sulaimabaliqis2@gmail.com");
//        updateRequest.setPhoneNumber("09132431343");
//        updateRequest.setPassword("123456");
//        updateRequest.setAddress("sabo yaba");
//        updateRequest.setCompanyName("Semicolon africa");
//        updateRequest.setCompanyRegNo("abcdef");
////        UpdateResponse response1 = userService.update(updateRequest);
//
//
//    }

}