package com.example.zoostore.api.operations.inputoutput.vendor.editproperties;

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
