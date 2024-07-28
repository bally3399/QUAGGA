package africa.semicolon.com.quagga.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table(name = "admins")
public class Admin {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private String id;
    private User user;

}
