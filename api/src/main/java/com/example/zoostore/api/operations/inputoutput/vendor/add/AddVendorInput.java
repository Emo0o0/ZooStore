package com.example.zoostore.api.operations.inputoutput.vendor.add;

import com.example.zoostore.api.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddVendorInput implements OperationInput {

    @NotBlank(message = "vendor name cannot be blank")
    private String name;
    @NotBlank(message = "vendor phone cannot be blank")
    private String phone;
}
