package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.Client;
import africa.semicolon.com.quagga.data.models.User;
import africa.semicolon.com.quagga.data.repositories.ClientRepository;
import africa.semicolon.com.quagga.dtos.response.DeleteUserResponse;
import africa.semicolon.com.quagga.exceptions.ClientNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService{

    private final ClientRepository clientRepository;

    private EmailService emailService;

    @Autowired
    public void setEmailService(@Lazy EmailService emailService) {
        this.emailService = emailService;
    }
    @Override
    public Client createClient(User savedUser) {
        Client newClient = new Client();
        newClient.setUser(savedUser);
        emailService.sendEmail(savedUser.getEmail(), "REGISTRATION SUCCESSFUL",
                "Hello " + savedUser.getFirstName() + " "
                + savedUser.getLastName() +
                        "\nYou have successfully registered to quagga as a " + savedUser.getRole()
                );
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

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findClientByUser(User user) {
        return clientRepository.findClientByUser(user);
    }

    @Override
    public void deleteAll() {
        clientRepository.deleteAll();
    }

}
