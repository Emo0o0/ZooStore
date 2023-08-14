package com.example.zoostore.api.operations.inputOutput.vendor.removeVendor;

import com.example.zoostore.api.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RemoveVendorOutput implements OperationResult {
    private String id;
}
