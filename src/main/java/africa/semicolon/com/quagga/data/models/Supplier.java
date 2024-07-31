package africa.semicolon.com.quagga.data.models;

import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Table(name = "suppliers")
public class Supplier {
    private String typeOfMaterial;
    private User user;
    private Review review;

}
