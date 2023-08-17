package com.example.zoostore.api.operations.inputoutput.vendor.editproperties;

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
