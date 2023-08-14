package com.example.zoostore.api.operations.inputOutput.item.addTagToItem;

import com.example.zoostore.api.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddTagToItemInput implements OperationInput {

    @NotBlank(message = "item id cannot be blank")
    private String itemId;
    @NotBlank(message = "tag name cannot be blank")
    private String tagName;

}
