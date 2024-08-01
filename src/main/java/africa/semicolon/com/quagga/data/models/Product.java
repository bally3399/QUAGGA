package africa.semicolon.com.quagga.data.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Setter
@Getter
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long productId;
    private Long userId;
    private String title;
    private String description;
    private String status;
    private List<Photo> photos;
    private double price;
    private String category;
    private String brand;
    private int quantity;
}
