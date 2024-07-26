package africa.semicolon.com.quagga.models;

import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table(name = "specialists")
public class Specialist {
    private String professionalSkills;
    private boolean availability;
    private User user;
    private Review review;
    private String companyName;
    private String companyRegNo;
}
