package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.Client;
import africa.semicolon.com.quagga.data.models.User;
import africa.semicolon.com.quagga.dtos.response.DeleteUserResponse;

import java.util.List;

public interface ClientService {
    Client createClient(User savedUser);

    Client findById(Long clientId);
    Client update(Client client);
    void deleteById(long id);

    List<Client> findAll();

    Client findClientByUser(User user);

    void deleteAll();
}
