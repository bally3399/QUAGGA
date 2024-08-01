package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.Supplier;
import africa.semicolon.com.quagga.dtos.request.RegisterRequest;
import africa.semicolon.com.quagga.dtos.response.RegisterResponse;

import africa.semicolon.com.quagga.data.repositories.SupplierRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;
    private final ModelMapper modelMapper;


    @Override
    public Supplier createSupplier(RegisterRequest request) {
        Supplier supplier = modelMapper.map(request, Supplier.class);

        RegisterResponse response = modelMapper.map(supplier, RegisterResponse.class);
        response.setMessage("Registration successful");
        return supplierRepository.save(supplier);

    }
}
