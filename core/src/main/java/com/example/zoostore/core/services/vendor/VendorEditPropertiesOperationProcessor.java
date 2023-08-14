package com.example.zoostore.core.services.vendor;

import com.example.zoostore.api.operations.inputOutput.vendor.editVendorProperties.EditVendorPropertiesInput;
import com.example.zoostore.api.operations.inputOutput.vendor.editVendorProperties.EditVendorPropertiesOutput;
import com.example.zoostore.api.operations.inputOutput.vendor.editVendorProperties.VendorEditPropertiesOperation;
import com.example.zoostore.core.exceptions.vendor.VendorNotFoundException;
import com.example.zoostore.persistence.entities.Vendor;
import com.example.zoostore.persistence.repository.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VendorEditPropertiesOperationProcessor implements VendorEditPropertiesOperation {

    private final VendorRepository vendorRepository;

    @Override
    public EditVendorPropertiesOutput process(EditVendorPropertiesInput input) {

        if (!vendorRepository.existsById(UUID.fromString(input.getVendorId()))) {
            throw new VendorNotFoundException("Vendor with this id was not found");
        }
        Optional<Vendor> optionalVendor = vendorRepository.findById(UUID.fromString(input.getVendorId()));
        Vendor vendor = optionalVendor.get();

        if (!input.getName().isBlank()) {
            vendor.setName(input.getName());
        }
        if (!input.getPhone().isBlank()) {
            vendor.setPhone(input.getPhone());
        }

        vendorRepository.save(vendor);

        EditVendorPropertiesOutput output = EditVendorPropertiesOutput.builder()
                .name(vendor.getName())
                .phone(vendor.getPhone())
                .build();

        return output;
    }
}
