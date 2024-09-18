package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.Category;
import africa.semicolon.com.quagga.data.models.Supplier;
import africa.semicolon.com.quagga.data.models.User;
import africa.semicolon.com.quagga.dtos.request.RegisterRequest;

import java.util.List;

public interface SupplierService {

     Supplier createSupplier(User user, RegisterRequest request);

    void deleteAll();

    List<Supplier> findAllSuppliers();

    List<Supplier> findSuppliersByCategory(Category category);
}
