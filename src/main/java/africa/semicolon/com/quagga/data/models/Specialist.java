package africa.semicolon.com.quagga.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table(name = "specialists")
@Entity
public class Specialist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long specialistId;
    private String professionalSkills;
    private boolean availability;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
    private String companyName;
    private String companyRegNo;
}
