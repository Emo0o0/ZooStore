package com.example.zoostore.api.operations.inputOutput.item.editItemProperties;

import com.example.zoostore.api.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EditItemPropertiesInput implements OperationInput {

    @NotBlank(message = "Item id must not be blank!")
    private String itemId;
    //@NotBlank(message = "Description must not be blank!")
    private String description;
    //@NotBlank(message = "ProductName must not be blank!")
    private String productName;
    @NotBlank(message = "VendorId must not be blank!")
    private String vendorId;

}
