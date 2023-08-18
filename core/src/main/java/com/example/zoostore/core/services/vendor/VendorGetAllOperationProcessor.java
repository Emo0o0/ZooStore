package com.example.zoostore.core.services.vendor;

import com.example.zoostore.api.operations.inputoutput.vendor.getall.GetAllVendorsInput;
import com.example.zoostore.persistence.entities.Vendor;
import com.example.zoostore.persistence.repository.VendorRepository;
import com.example.zoostore.api.operations.inputoutput.vendor.getall.GetAllVendorsOutput;
import com.example.zoostore.api.operations.inputoutput.vendor.getall.VendorGetAllOperation;
import com.example.zoostore.api.operations.inputoutput.vendor.getbyid.ItemsToDtoSetMap;
import com.example.zoostore.api.operations.inputoutput.vendor.getbyid.GetVendorByIdOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VendorGetAllOperationProcessor implements VendorGetAllOperation {

    private final VendorRepository vendorRepository;

    @Override
    public GetAllVendorsOutput process(GetAllVendorsInput input) {

        List<Vendor> optionalVendor = vendorRepository.findAll();
        GetVendorByIdOutput output;
        GetAllVendorsOutput outputSet = GetAllVendorsOutput.builder()
                .vendorList(optionalVendor.stream()
                        .map(vendor -> GetVendorByIdOutput.builder()
                                .id(vendor.getId().toString())
                                .name(vendor.getName())
                                .phone(vendor.getPhone())
                                .items(ItemsToDtoSetMap.mapSets(vendor.getItems()))
                                .build())
                        .collect(Collectors.toSet()))
                .build();

        return outputSet;
    }
}
