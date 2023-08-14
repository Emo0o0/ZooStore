package com.example.zoostore.core.services.vendor;

import com.example.zoostore.persistence.entities.Vendor;
import com.example.zoostore.persistence.repository.VendorRepository;
import com.example.zoostore.api.operations.inputOutput.vendor.addVendor.AddVendorInput;
import com.example.zoostore.api.operations.inputOutput.vendor.addVendor.AddVendorOutput;
import com.example.zoostore.api.operations.inputOutput.vendor.addVendor.VendorAddOperation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VendorAddOperationProcessor implements VendorAddOperation {

    private final VendorRepository vendorRepository;

    @Override
    public AddVendorOutput process(AddVendorInput input) {
        Vendor vendor = Vendor.builder()
                .name(input.getName())
                .phone(input.getPhone())
                .build();

        vendorRepository.save(vendor);

        AddVendorOutput addVendorOutput = AddVendorOutput.builder()
                .id(vendor.getId().toString())
                .build();
        return addVendorOutput;
    }
}
