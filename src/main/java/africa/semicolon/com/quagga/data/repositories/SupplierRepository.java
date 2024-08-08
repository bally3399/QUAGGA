package africa.semicolon.com.quagga.data.repositories;

import africa.semicolon.com.quagga.data.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}
