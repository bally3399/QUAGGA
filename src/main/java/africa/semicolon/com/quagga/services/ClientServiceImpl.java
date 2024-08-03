package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.Client;
import africa.semicolon.com.quagga.data.models.User;
import africa.semicolon.com.quagga.data.repositories.ClientRepository;
import africa.semicolon.com.quagga.exceptions.ClientNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService{

    private final ClientRepository clientRepository;
    private final UserService userService;

    @Override
    public Client createClient(User savedUser) {
        Client newClient = new Client();
        newClient.setUser(savedUser);
        return clientRepository.save(newClient);
    }

    @Override
    public Client findById(Long clientId) {
        return clientRepository.findById(clientId)
                .orElseThrow(()-> new ClientNotFoundException("Client with id: " + clientId + " does not exist"));
    }

    @Override
    public UpdateClientResponse update(UpdateClientRequest updateClientRequest) {
        Client client = findById(updateClientRequest.getClientId());
        if (updateClientRequest.getFirstName() != null){
            client.getUser().setFirstName(updateClientRequest.getFirstName());
        }
        if (updateClientRequest.getLastName() != null){
            client.getUser().setLastName(updateClientRequest.getLastName());
        }
        if (updateClientRequest.getEmail() != null){
            client.getUser().setEmail(updateClientRequest.getEmail());
        }
        if (updateClientRequest.getAddress() != null){
            client.getUser().setAddress(updateClientRequest.getAddress());
        }
        if (updateClientRequest.getPhoneNumber() != null){
            client.getUser().setPhoneNumber(updateClientRequest.getPhoneNumber());
        }
        if (updateClientRequest.getPassword() != null){
            client.getUser().setPassword(updateClientRequest.getPassword());
        }
        clientRepository.save(client);
        User user = userService.getById(client.getUser().getId());
        userService.save(user);
        UpdateClientResponse response = new UpdateClientResponse();
        response.setMessage("Client updated successfully");
        return response;
    }

}
