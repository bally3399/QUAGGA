package africa.semicolon.com.quagga.repository;

import africa.semicolon.com.quagga.data.models.Specialist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialistRepository extends JpaRepository<Specialist, Long> {
}
