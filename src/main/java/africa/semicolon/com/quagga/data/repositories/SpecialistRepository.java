package africa.semicolon.com.quagga.data.repositories;

import africa.semicolon.com.quagga.data.models.Specialist;
import africa.semicolon.com.quagga.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialistRepository extends JpaRepository<Specialist, Long> {
    Specialist findByUserId(long id);
    Specialist findSpecialistByUser(User user);
}
