package africa.semicolon.com.quagga.data.repositories;

import africa.semicolon.com.quagga.data.models.Client;
import africa.semicolon.com.quagga.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findClientByUser (User user);
}
