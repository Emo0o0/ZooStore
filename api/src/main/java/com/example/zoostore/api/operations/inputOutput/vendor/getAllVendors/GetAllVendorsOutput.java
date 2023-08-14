package com.example.zoostore.api.operations.inputOutput.vendor.getAllVendors;

import com.example.zoostore.api.base.OperationResult;
import com.example.zoostore.api.operations.inputOutput.vendor.getVendorById.GetVendorByIdOutput;
import lombok.*;

import java.util.Set;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetAllVendorsOutput implements OperationResult {
    private Set<GetVendorByIdOutput> vendorList;
}
