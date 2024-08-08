package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.Product;
import africa.semicolon.com.quagga.data.models.Supplier;
import africa.semicolon.com.quagga.data.repositories.ProductRepository;
import africa.semicolon.com.quagga.data.repositories.SupplierRepository;
import africa.semicolon.com.quagga.dtos.request.CreateProductRequest;
import africa.semicolon.com.quagga.dtos.response.CreateProductResponse;
import africa.semicolon.com.quagga.exceptions.CreateProductFailedException;
import com.cloudinary.Cloudinary;
import com.cloudinary.Uploader;
import com.cloudinary.utils.ObjectUtils;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final SupplierService supplierService;
    private final ProductRepository productRepository;
    private final Cloudinary cloudinary;
    private final ModelMapper modelMapper;
    @Override
    public CreateProductResponse createProduct(CreateProductRequest createProductRequest){
        Supplier supplier = supplierService.getById(createProductRequest.getSupplierId());
        try{
            Uploader uploader = cloudinary.uploader();
            Map<? , ?> response = uploader.upload(createProductRequest.getMediaFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
            String url = response.get("url").toString();
            Product product = modelMapper.map(createProductRequest, Product.class);
            product.setImageUrl(url);
            product.setSupplier(supplier);
            product = productRepository.save(product);
            return modelMapper.map(product, CreateProductResponse.class);
        }
        catch(IOException exception) {
            throw new CreateProductFailedException("media upload failed");
        }

    }


    @Override
    public List<Product> searchByName(String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }


}
