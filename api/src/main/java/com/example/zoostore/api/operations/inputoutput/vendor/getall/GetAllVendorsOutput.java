package com.example.zoostore.api.operations.inputoutput.vendor.getall;

import com.example.zoostore.api.base.OperationResult;
import com.example.zoostore.api.operations.inputoutput.vendor.getbyid.GetVendorByIdOutput;
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
