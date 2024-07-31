package africa.semicolon.com.quagga.data.repositories;

import africa.semicolon.com.quagga.data.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}
