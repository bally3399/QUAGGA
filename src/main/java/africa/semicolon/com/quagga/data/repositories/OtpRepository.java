package africa.semicolon.com.quagga.data.repositories;

import africa.semicolon.com.quagga.data.models.Otp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OtpRepository extends JpaRepository<Otp, Long> {
    Otp findByNumber(String otp);
}
