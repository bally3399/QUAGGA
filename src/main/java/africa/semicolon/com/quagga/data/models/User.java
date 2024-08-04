package africa.semicolon.com.quagga.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Setter
@Getter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;
    private String password;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String LGA;
    @Column(nullable = false)
    private String state;
    @Column(nullable = false)
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private Role role;
    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<Authority> authorities;
}
