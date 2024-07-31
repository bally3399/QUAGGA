package africa.semicolon.com.quagga.data.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Table(name = "suppliers")
public class Supplier {
    private String typeOfMaterial;
    private List<Product> products;
    private User user;
    private Review review;

}
