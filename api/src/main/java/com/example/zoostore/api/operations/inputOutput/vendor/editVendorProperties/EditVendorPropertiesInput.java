package com.example.zoostore.api.operations.inputOutput.vendor.editVendorProperties;

import com.example.zoostore.api.base.OperationInput;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EditVendorPropertiesInput implements OperationInput {

    private String vendorId;
    private String name;
    private String phone;

}
