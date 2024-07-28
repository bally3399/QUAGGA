package africa.semicolon.com.quagga.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Setter
@Getter
@Table(name = "professionals")
@Entity
public class Professional {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private Long profileId;
    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
