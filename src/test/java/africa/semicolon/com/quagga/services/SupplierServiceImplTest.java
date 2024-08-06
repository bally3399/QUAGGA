package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.Category;
import africa.semicolon.com.quagga.data.models.SubCategory;
import africa.semicolon.com.quagga.dtos.request.CreateProductRequest;
import africa.semicolon.com.quagga.dtos.request.RegisterRequest;

import africa.semicolon.com.quagga.dtos.response.CreateProductResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static africa.semicolon.com.quagga.data.models.Role.SUPPLIER;
import africa.semicolon.com.quagga.dtos.response.RegisterResponse;

import static africa.semicolon.com.quagga.services.TestUtils.TEST_IMAGE_LOCATION;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
@SpringBootTest
class SupplierServiceImplTest {
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

    @Test
    void createSupplier() {
        RegisterRequest request = new RegisterRequest();
        request.setFirstName("sam");
        request.setLastName("Doe");
        request.setPassword("password");
        request.setEmail("johndbeloved@gmail.com");
        request.setAddress("No 30, Helen Street, Idumota, Lagos");
        request.setPhoneNumber("08123456789");
        request.setRole(SUPPLIER);
        request.setCategory(Category.ELECTRICAL);
        RegisterResponse response = userService.register(request);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Registration successful");

    }

    @Test
    void testSupplierCanCreateProduct(){
        RegisterRequest request = new RegisterRequest();
        request.setFirstName("sam");
        request.setLastName("Olu");
        request.setPassword("passwordss");
        request.setEmail("samdbeloved@gmail.com");
        request.setAddress("No 50, Helen Street, Idumota, Lagos");
        request.setPhoneNumber("08123456889");
        request.setRole(SUPPLIER);
        request.setCategory(Category.MECHANICAL);
        RegisterResponse response = userService.register(request);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Registration successful");
        CreateProductRequest firstRequest = new CreateProductRequest();
        firstRequest.setName("Wire");
        firstRequest.setDescription("4mm wire 250m length");
        firstRequest.setCategory(Category.ELECTRICAL);
        firstRequest.setSubCategory(SubCategory.INDUSTRIAL_ELECTRICAL);
        firstRequest.setBrand("coleman");
        firstRequest.setPrice(5000.0);
        firstRequest.setImageUrl(TEST_IMAGE_LOCATION);
        firstRequest.setSupplierId(1L);
        CreateProductResponse createProductResponse = productService.createProduct(firstRequest);
        assertThat(createProductResponse).isNotNull();
        assertThat(createProductResponse.getMessage()).isEqualTo("Product created successfully");

    }
}