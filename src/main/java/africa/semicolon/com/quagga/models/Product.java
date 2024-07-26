package africa.semicolon.com.quagga.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Setter
@Getter
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long projectId;
    private Long userId;
    private String title;
    private String description;
    private String status;
    private String vr;
}
