package africa.semicolon.com.quagga.data.repositories;

import africa.semicolon.com.quagga.data.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
