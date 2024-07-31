package africa.semicolon.com.quagga.data.repositories;

import africa.semicolon.com.quagga.data.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
