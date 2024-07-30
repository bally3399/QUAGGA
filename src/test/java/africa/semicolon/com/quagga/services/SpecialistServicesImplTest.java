package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.Specialist;
import africa.semicolon.com.quagga.data.models.User;
import africa.semicolon.com.quagga.dtos.request.RegisterRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static africa.semicolon.com.quagga.data.models.Role.SPECIALIST;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
public class SpecialistServicesImplTest {
    @Autowired
    private SpecialistService specialistService;

//    @Test
//    public void registerSpecialistTest() {
//        RegisterRequest request = new RegisterRequest();
//        request.setFirstName("Sulaiman");
//        request.setLastName("Baliqis");
//        request.setEmail("sulaimabaliqis@gmail.com");
//        request.setPassword("123456");
//        request.setAddress("sabo yaba");
//        request.setRole(SPECIALIST);
//        request.setCompanyName("Semicolon");
//        request.setCompanyRegNo("abcd");
//        request.setUsername("bally");
//        request.setProfessionalSkills("Construction");
//        RegisterSpecialistResponse response = specialistService.createSpecialist(request);
//        assertThat(response).isNotNull();
//        assertThat(response.getMessage()).isEqualTo("Specialist registered successfully");
//
//    }

    @Test
    public void testThatSpecialistCanBeCreated() {
        //Given that
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
        request.setProfessionalSkills(List.of("Construction", "Painting"));

        User user = new User();
        user.setFirstName("Sulaiman");
        user.setLastName("Baliqis");
        user.setEmail("sulaimabaliqis@gmail.com");
        user.setPassword("123456");
        user.setAddress("Sabo Yaba");
        user.setRole(SPECIALIST);

        //When I
        Specialist response = specialistService.createSpecialist(user, request);
        //Assert that
        assertThat(response.getSpecialistId(), is(1L));
        assertThat(response.getCompanyRegNo(), is(request.getCompanyRegNo()));
    }
}