package africa.semicolon.com.quagga.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Setter
@Getter
@Entity
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
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
}
