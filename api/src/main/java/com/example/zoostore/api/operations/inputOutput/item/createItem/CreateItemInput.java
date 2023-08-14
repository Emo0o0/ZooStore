package com.example.zoostore.api.operations.inputOutput.item.createItem;

import com.example.zoostore.api.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateItemInput implements OperationInput {

    @NotBlank(message = "item title cannot be blank")
    private String title;
    @NotBlank(message = "item description cannot be blank")
    private String description;
    @NotBlank(message = "vendor id cannot be blank")
    private String vendorID;
}
