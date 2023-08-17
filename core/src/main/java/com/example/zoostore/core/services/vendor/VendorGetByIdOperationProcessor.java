package com.example.zoostore.core.services.vendor;

import com.example.zoostore.core.exceptions.item.ItemNotFoundException;
import com.example.zoostore.persistence.entities.Vendor;
import com.example.zoostore.persistence.repository.VendorRepository;
import com.example.zoostore.api.operations.inputoutput.vendor.getbyid.GetVendorByIdInput;
import com.example.zoostore.api.operations.inputoutput.vendor.getbyid.ItemsToDtoSetMap;
import com.example.zoostore.api.operations.inputoutput.vendor.getbyid.GetVendorByIdOutput;
import com.example.zoostore.api.operations.inputoutput.vendor.getbyid.VendorGetByIdOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VendorGetByIdOperationProcessor implements VendorGetByIdOperation {
    private final VendorRepository vendorRepository;

    @Override
    public GetVendorByIdOutput process(GetVendorByIdInput input) {

        if(!vendorRepository.existsById(UUID.fromString(input.getId()))){
            throw new ItemNotFoundException("No vendor with the given id was found");
        }

        Optional<Vendor> optionalVendor = vendorRepository.findById(UUID.fromString(input.getId()));
        Vendor vendor = optionalVendor.get();



        GetVendorByIdOutput getVendorByIdOutput = GetVendorByIdOutput.builder()
                .id(vendor.getId().toString())
                .name(vendor.getName())
                .phone((vendor.getPhone()))
                .items(ItemsToDtoSetMap.mapSets(vendor.getItems()))
                .build();

        return getVendorByIdOutput;
    }
}
