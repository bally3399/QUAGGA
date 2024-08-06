package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.Product;
import africa.semicolon.com.quagga.dtos.request.CreateProductRequest;
import africa.semicolon.com.quagga.dtos.response.CreateProductResponse;

public interface ProductService {
     CreateProductResponse createProduct(CreateProductRequest createProductRequest);
}
