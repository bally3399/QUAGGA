package africa.semicolon.com.quagga.data.repositories;

import africa.semicolon.com.quagga.data.models.ServiceRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<ServiceRequest, Long> {

}
