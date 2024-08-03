package africa.semicolon.com.quagga.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Setter
@Getter
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long productId;
    private Long userId;
    private String name;
    private String description;
    private String status;
    @Column(nullable = true)
    private String imageUrl;
    private double price;
    @Enumerated(EnumType.STRING)
    private Category category;
    @Enumerated(EnumType.STRING)
    private SubCategory subCategory;
    private String brand;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
}
