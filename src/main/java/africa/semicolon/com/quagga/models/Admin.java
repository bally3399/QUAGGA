package africa.semicolon.com.quagga.models;

import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table(name = "admins")
public class Admin {
    private User user;
    //hi

}
