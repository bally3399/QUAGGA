package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.User;
import africa.semicolon.com.quagga.data.repositories.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class QuaggaClient implements ClientService{
    private final ClientRepository clientRepository;

    public QuaggaClient(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Override
    public void createClient(User savedUser) {
        clientRepository.save(savedUser);
    }
}
