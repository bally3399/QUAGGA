package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.*;
import africa.semicolon.com.quagga.dtos.request.*;
import africa.semicolon.com.quagga.dtos.response.*;
import africa.semicolon.com.quagga.exceptions.UserNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
    public SupplierService supplierService;

    @Autowired
    public ServiceRequestServices requestService;
    private User client;
    private User specialist;
    private User supplier;

    private RegisterResponse clientsResponse;
    private RegisterResponse specialistResponse;
    private RegisterResponse supplierResponse;



    @BeforeEach
    public void setUserService(){
        requestService.deleteAll();
        clientService.deleteAll();
        specialistService.deleteAll();
        supplierService.deleteAll();
        userService.deleteAll();
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

        clientsResponse = userService.register(request);
        client = clientsResponse.getUser();

        RegisterRequest request2 = new RegisterRequest();
        request2.setFirstName("Seun");
        request2.setLastName("Bond");
        request2.setPassword("9111");
        request2.setEmail("seun@gmail.com");
        request2.setAddress("No 30, Helena Street, Idumota, Lagos");
        request2.setPhoneNumber("08134856789");
        request2.setRole(Role.SPECIALIST);
        request2.setCategory(Category.STRUCTURAL);
        request2.setLGA("Sabo");
        request2.setState("Lagos");

        specialistResponse = userService.register(request2);
        specialist = specialistResponse.getUser();

        RegisterRequest request3 = new RegisterRequest();
        request3.setFirstName("Tayo");
        request3.setLastName("Bond");
        request3.setPassword("9211");
        request3.setEmail("tayo@gmail.com");
        request3.setAddress("No 30, Helenaw Street, Idumota, Lagos");
        request3.setPhoneNumber("08134556789");
        request3.setRole(Role.SUPPLIER);
        request3.setCategory(Category.STRUCTURAL);
        request3.setLGA("Sabo");
        request3.setState("Lagos");

        supplierResponse = userService.register(request3);
        supplier = supplierResponse.getUser();
    }

    @Test
    public void testRegisterClient(){

        assertThat(clientsResponse).isNotNull();
        assertThat(clientsResponse.getMessage()).isEqualTo("Registration successful");
        clientService.deleteAll();
        specialistService.deleteAll();
        supplierService.deleteAll();
        userService.deleteAll();
    }

    @Test
    public void testLoginClient(){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail("paul@gmail.com");
        loginRequest.setPassword("911");
        LoginResponse loginResponse = userService.login(loginRequest);
        assertThat(loginResponse).isNotNull();
        clientService.deleteAll();
        specialistService.deleteAll();
        supplierService.deleteAll();
        userService.deleteAll();
    }

    @Test
    public void testLogoutClient(){
        LogoutRequest logoutRequest = new LogoutRequest();
        logoutRequest.setEmail("paul@gmail.com");
        LogoutResponse logoutResponse = userService.logout(logoutRequest);

    }

    @Test
    @DisplayName("Test that client can be retrieved by id")
    public void testGetClientById() {
        Client client = clientService.findClientByUser(this.client);
        assertThat(client).isNotNull();
        clientService.deleteAll();
        specialistService.deleteAll();
        supplierService.deleteAll();
        userService.deleteAll();
    }

    @Test
    public void testFindAllSpecialist(){
        List<Specialist> specialistList = specialistService.findAllSpecialist();
        assertThat(specialistList).isNotEmpty();
        clientService.deleteAll();
        specialistService.deleteAll();
        supplierService.deleteAll();
        userService.deleteAll();
    }

    @Test
    public void testFindAllSupplier(){
        List<User> supplierList = userService.getAllSupplier();
        assertThat(supplierList).isNotEmpty();
        clientService.deleteAll();
        specialistService.deleteAll();
        supplierService.deleteAll();
        userService.deleteAll();
    }

    @Test
    public void testFindOnlyAvailableSpecialist(){
        List<Specialist> availableSpecialists = specialistService.findAllAvailableSpecialist();
        assertThat(availableSpecialists.size()).isEqualTo(1L);
        clientService.deleteAll();
        specialistService.deleteAll();
        supplierService.deleteAll();
        userService.deleteAll();
    }

    @Test
    public void testUpdateClientInfo(){
        Client foundClient = clientService.findClientByUser(client);
        assertThat(foundClient).isNotNull();
        UpdateClientRequest updateClientRequest = new UpdateClientRequest();
        updateClientRequest.setClientId(foundClient.getId());
        updateClientRequest.setFirstName("Fresh");
        updateClientRequest.setLastName("Name");
        //updateClientRequest.setAddress("UpdatedAddress");
        //updateClientRequest.setPassword("UpdatedPassword");
        // updateClientRequest.setPhoneNumber("419");

        UpdateClientResponse response = userService.update(updateClientRequest);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Client updated successfully");

        Client updatedClient = clientService.findClientByUser(client);
        assertThat(updatedClient.getUser().getPhoneNumber()).isEqualTo("08133856789");
        assertThat(updatedClient.getUser().getFirstName()).isEqualTo("Fresh");
        clientService.deleteAll();
        specialistService.deleteAll();
        supplierService.deleteAll();
        userService.deleteAll();
    }

    @Test
    public void deleteClient(){
        Client foundClient = clientService.findClientByUser(client);
        assertThat(foundClient).isNotNull();
        userService.deleteClientById(foundClient.getId());
//        userService.deleteClientById(12L);
        assertThrows(UserNotFoundException.class, ()->userService.getById(client.getId()));
        clientService.deleteAll();
        specialistService.deleteAll();
        supplierService.deleteAll();
        userService.deleteAll();
    }

    @Test
    public void testThatClientCanCreateServiceRequest() {
        Client foundClient = clientService.findClientByUser(client);
        Specialist foundSpecialist = specialistService.findSpecialistByUser(specialist);
        CreateServiceRequest serviceRequest = new CreateServiceRequest();
        serviceRequest.setClientId(foundClient.getId());
        serviceRequest.setSpecialistId(foundSpecialist.getSpecialistId());
        serviceRequest.setServiceDescription("I am in need of plumbing service");
        ServiceRequestResponse response = requestService.create(serviceRequest);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Request sent successfully");
        requestService.deleteAll();
        clientService.deleteAll();
        specialistService.deleteAll();
        supplierService.deleteAll();
        userService.deleteAll();
    }

    @Test
    public void testThatUserCanUseForgetPassword(){

    }


}
