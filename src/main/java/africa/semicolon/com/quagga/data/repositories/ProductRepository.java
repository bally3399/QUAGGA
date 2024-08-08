package africa.semicolon.com.quagga.data.repositories;

import africa.semicolon.com.quagga.data.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>  {

    List<Product> findByNameContainingIgnoreCase(String name);
}
