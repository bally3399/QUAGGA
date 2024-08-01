package africa.semicolon.com.quagga.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Table(name = "specialists")
@Entity
public class Specialist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long specialistId;
    @ElementCollection
    @CollectionTable(name = "professional_skills", joinColumns = @JoinColumn(name = "specialist_id"))
    @Column(name = "skill")
    private List<String> professionalSkills;
    private boolean availability;
    @OneToOne
    private User user;
    private String companyName;
    private String companyRegNo;

}
