package africa.semicolon.com.quagga.data.models;

import jakarta.persistence.*;
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
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Long supplierId;
    private String title;
    private String description;
    private String status;
    private String vr;
}
