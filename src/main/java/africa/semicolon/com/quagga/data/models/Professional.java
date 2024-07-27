package africa.semicolon.com.quagga.data.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Setter
@Getter
@Table(name = "professionals")
public class Professional {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private Long profileId;
}
