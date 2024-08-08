package africa.semicolon.com.quagga.dtos.request;

import africa.semicolon.com.quagga.data.models.Category;
import africa.semicolon.com.quagga.data.models.SubCategory;
import africa.semicolon.com.quagga.data.models.Supplier;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Setter
@Getter
public class CreateProductRequest {
    private Long supplierId;
    private String name;
    private String description;
    private MultipartFile mediaFile;
    private double price;
    private Category category;
    private SubCategory subCategory;
    private String brand;
    private int quantity;
}
