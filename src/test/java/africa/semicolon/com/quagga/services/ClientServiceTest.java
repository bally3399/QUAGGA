package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.*;
import africa.semicolon.com.quagga.dtos.request.CreateServiceRequest;
import africa.semicolon.com.quagga.dtos.request.LoginRequest;
import africa.semicolon.com.quagga.dtos.request.RegisterRequest;
import africa.semicolon.com.quagga.dtos.request.UpdateClientRequest;
import africa.semicolon.com.quagga.dtos.response.LoginResponse;
import africa.semicolon.com.quagga.dtos.response.RegisterResponse;
import africa.semicolon.com.quagga.dtos.response.ServiceRequestResponse;
import africa.semicolon.com.quagga.dtos.response.UpdateClientResponse;
import africa.semicolon.com.quagga.exceptions.UserNotFoundException;
import org.apache.http.auth.InvalidCredentialsException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
//@Sql(scripts = {"/db/data.sql"})
public class ClientServiceTest {

    @Autowired
    public UserService userService;

    @Autowired
    public ClientService clientService;

    @Autowired
    public SpecialistService specialistService;

    @Autowired
    public ServiceRequestServices requestService;

    @Test
    public void testRegisterClient(){
        RegisterRequest request = new RegisterRequest();
        request.setFirstName("Paul");
        request.setLastName("Bond");
        request.setPassword("911");
        request.setEmail("paul@gmail.com");
        request.setAddress("No 30, Helen Street, Idumota, Lagos");
        request.setPhoneNumber("08133856789");
        request.setRole(Role.CLIENT);
        request.setCategory(Category.STRUCTURAL);
        request.setLGA("Sabo");
        request.setState("Lagos");

        RegisterResponse response = userService.register(request);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Registration successful");
    }

    @Test
    public void testLoginClient(){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail("naruto@gmail.com");
        loginRequest.setPassword("1234");
        LoginResponse loginResponse = userService.login(loginRequest);
        assertThat(loginResponse).isNotNull();
    }

    @Test
    @DisplayName("Test that client can be retrieved by id")
    public void testGetClientById() {
        Client client = clientService.findById(11L);
        assertThat(client).isNotNull();
        assertThat(client.getId()).isEqualTo(11L);
    }

    @Test
    public void testFindAllSpecialist(){
        List<Specialist> specialistList = specialistService.findAllSpecialist();
        assertThat(specialistList).isNotEmpty();
    }

    @Test
    public void testFindAllSupplier(){
        List<User> specialistList = userService.getAllSupplier();
        assertThat(specialistList).isNotEmpty();
    }

    @Test
    public void testFindOnlyAvailableSpecialist(){
        List<Specialist> availableSpecialists = specialistService.findAllAvailableSpecialist();
        assertThat(availableSpecialists.size()).isEqualTo(5L);
    }

    @Test
    public void testUpdateClientInfo(){
        Client client = clientService.findById(10L);
        assertThat(client).isNotNull();
        UpdateClientRequest updateClientRequest = new UpdateClientRequest();
        updateClientRequest.setClientId(10L);
        updateClientRequest.setFirstName("Fresh");
        updateClientRequest.setLastName("Name");
        //updateClientRequest.setAddress("UpdatedAddress");
        //updateClientRequest.setPassword("UpdatedPassword");
        // updateClientRequest.setPhoneNumber("419");

        UpdateClientResponse response = userService.update(updateClientRequest);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Client updated successfully");

        Client updatedClient = clientService.findById(10L);
        assertThat(updatedClient.getUser().getPhoneNumber()).isEqualTo("08123456789");
        assertThat(updatedClient.getUser().getFirstName()).isEqualTo("Fresh");
    }

    @Test
    public void deleteClient(){
        Client client = userService.findClientById(303L);
        assertThat(client).isNotNull();
        userService.deleteClientById(303L);
//        userService.deleteClientById(12L);
        assertThrows(UserNotFoundException.class, ()->userService.getById(303L));
    }

    @Test
    public void testThatClientCanCreateServiceRequest() {
        CreateServiceRequest serviceRequest = new CreateServiceRequest();
        serviceRequest.setClientId(300L);
        serviceRequest.setSpecialistId(203L);
        serviceRequest.setServiceDescription("I am in need of plumbing service");
        ServiceRequestResponse response = requestService.create(serviceRequest);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Request sent successfully");
    }


}
