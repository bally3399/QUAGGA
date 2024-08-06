package africa.semicolon.com.quagga.data.repositories;

import africa.semicolon.com.quagga.data.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>  {

}
