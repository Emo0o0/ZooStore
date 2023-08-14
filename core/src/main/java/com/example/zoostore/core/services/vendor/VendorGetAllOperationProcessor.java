package com.example.zoostore.core.services.vendor;

import com.example.zoostore.api.operations.inputOutput.vendor.getAllVendors.GetAllVendorsInput;
import com.example.zoostore.persistence.entities.Vendor;
import com.example.zoostore.persistence.repository.VendorRepository;
import com.example.zoostore.api.operations.inputOutput.vendor.getAllVendors.GetAllVendorsOutput;
import com.example.zoostore.api.operations.inputOutput.vendor.getAllVendors.VendorGetAllOperation;
import com.example.zoostore.api.operations.inputOutput.vendor.getVendorById.ItemsToDtoSetMap;
import com.example.zoostore.api.operations.inputOutput.vendor.getVendorById.GetVendorByIdOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VendorGetAllOperationProcessor implements VendorGetAllOperation {

    private final VendorRepository vendorRepository;

    @Override
    public GetAllVendorsOutput process(GetAllVendorsInput input) {
        List<Vendor> optionalVendor = vendorRepository.findAll();
        GetVendorByIdOutput output;
        GetAllVendorsOutput outputList = GetAllVendorsOutput.builder()
                .vendorList(new HashSet<>())
                .build();
        for (Vendor vendor : optionalVendor) {
            output = GetVendorByIdOutput.builder()
                    .id(vendor.getId().toString())
                    .name(vendor.getName())
                    .phone(vendor.getPhone())
                    .items(ItemsToDtoSetMap.mapSets(vendor.getItems()))
                    .build();
            outputList.getVendorList().add(output);
        }
        return outputList;
    }
}
