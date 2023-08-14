package com.example.zoostore.api.operations.inputOutput.vendor.editVendorProperties;

import com.example.zoostore.api.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EditVendorPropertiesOutput implements OperationResult {

    private String name;
    private String phone;
}
