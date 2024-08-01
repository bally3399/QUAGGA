package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.Supplier;
import africa.semicolon.com.quagga.dtos.request.RegisterRequest;

public interface SupplierService {

    Supplier createSupplier(RegisterRequest request);
}
