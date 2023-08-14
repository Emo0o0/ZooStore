package com.example.zoostore.api.operations.inputOutput.vendor.addVendor;

import com.example.zoostore.api.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddVendorOutput implements OperationResult {

    private String id;
}
