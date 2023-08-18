package com.example.zoostore.core.services.vendor;

import com.example.zoostore.core.exceptions.item.ItemNotFoundException;
import com.example.zoostore.persistence.entities.Vendor;
import com.example.zoostore.persistence.repository.VendorRepository;
import com.example.zoostore.api.operations.inputoutput.vendor.remove.RemoveVendorInput;
import com.example.zoostore.api.operations.inputoutput.vendor.remove.RemoveVendorOutput;
import com.example.zoostore.api.operations.inputoutput.vendor.remove.VendorRemoveOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VendorRemoveOperationProcessor implements VendorRemoveOperation {

    private final VendorRepository vendorRepository;

    @Override
    public RemoveVendorOutput process(RemoveVendorInput input) {

        if(!vendorRepository.existsById(UUID.fromString(input.getId()))){
            throw new ItemNotFoundException("No vendor with the given id was found");
        }

        Optional<Vendor> optionalVendor = vendorRepository.findById(UUID.fromString(input.getId()));
        Vendor vendor = optionalVendor.get();

        vendorRepository.delete(vendor);

        RemoveVendorOutput output = RemoveVendorOutput.builder()
                .id(input.getId().toString())
                .build();

        return output;
    }
}
