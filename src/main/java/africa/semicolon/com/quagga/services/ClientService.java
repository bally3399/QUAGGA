package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.Client;
import africa.semicolon.com.quagga.data.models.User;

public interface ClientService {
    Client createClient(User savedUser);
    Client findById(Long clientId);
    Client update(Client client);


}
