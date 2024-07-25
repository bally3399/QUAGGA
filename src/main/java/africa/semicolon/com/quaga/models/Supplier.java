package africa.semicolon.com.quaga.models;

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
