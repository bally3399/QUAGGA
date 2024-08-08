package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.Supplier;
import africa.semicolon.com.quagga.data.models.User;
import africa.semicolon.com.quagga.data.repositories.SupplierRepository;
import africa.semicolon.com.quagga.dtos.request.RegisterRequest;

import africa.semicolon.com.quagga.exceptions.SupplierNotFoundException;
import africa.semicolon.com.quagga.exceptions.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;


    @Override
    public Supplier createSupplier(User savedUser, RegisterRequest request) {
        Supplier newSupplier = new Supplier();
        newSupplier.setUser(savedUser);
        newSupplier.setCategory(request.getCategory());
        return supplierRepository.save(newSupplier);
    }

    @Override
    public Supplier getById(long id) {
        return supplierRepository.findById(id)
                .orElseThrow(() -> new SupplierNotFoundException("Supplier does not exist"));


    }

}
