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
    public Client update(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void deleteById(long id) {
        clientRepository.deleteById(id);
    }

}
