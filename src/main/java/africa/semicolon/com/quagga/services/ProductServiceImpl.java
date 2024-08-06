package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.Product;
import africa.semicolon.com.quagga.data.models.Supplier;
import africa.semicolon.com.quagga.data.repositories.ProductRepository;
import africa.semicolon.com.quagga.data.repositories.SupplierRepository;
import africa.semicolon.com.quagga.dtos.request.CreateProductRequest;
import africa.semicolon.com.quagga.dtos.response.CreateProductResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final SupplierService supplierService;
    private final ProductRepository productRepository;
    @Override
    public CreateProductResponse createProduct(CreateProductRequest createProductRequest){
        Supplier supplier = supplierService.getById(createProductRequest.getSupplierId());
        Product newProduct = new Product();
        newProduct.setSupplier(supplier);
        newProduct.setName(createProductRequest.getName());
        newProduct.setDescription(createProductRequest.getDescription());
        newProduct.setPrice(createProductRequest.getPrice());
        newProduct.setBrand(createProductRequest.getBrand());
        newProduct.setImageUrl(createProductRequest.getImageUrl());
        newProduct.setCategory(createProductRequest.getCategory());
        newProduct.setSubCategory(createProductRequest.getSubCategory());
        productRepository.save(newProduct);

        CreateProductResponse response = new CreateProductResponse();
        response.setMessage("Product created successfully");
        return response;


    }


}
