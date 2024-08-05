package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.Category;
import africa.semicolon.com.quagga.data.models.SubCategory;
import africa.semicolon.com.quagga.dtos.request.AcceptServiceRequest;
import africa.semicolon.com.quagga.dtos.request.RegisterRequest;
import africa.semicolon.com.quagga.dtos.response.AcceptServiceResponse;
import africa.semicolon.com.quagga.dtos.response.RegisterResponse;
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

    @Autowired
    private ServiceRequestServices serviceRequestServices;

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
        request.setLGA("Sabo");
        request.setState("Lagos");
        request.setCategory(Category.STRUCTURAL);
        request.setSubCategory(SubCategory.ACOUSTICS);
        RegisterResponse response = userService.register(request);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Registration successful");

    }

    @Test
    public void testThatSpecialistCanAcceptServiceRequest(){
        AcceptServiceRequest serviceRequest = new AcceptServiceRequest();
        serviceRequest.setServiceId(3L);
        serviceRequest.setSpecialistId(203L);
        AcceptServiceResponse response = serviceRequestServices.accept(serviceRequest);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Service accepted");
    }

}