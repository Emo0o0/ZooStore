package com.example.zoostore.api.operations.inputOutput.vendor.getVendorById;

import com.example.zoostore.api.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetVendorByIdInput implements OperationInput {

    @NotBlank(message = "vendor id cannot be blank")
    private String id;
}
