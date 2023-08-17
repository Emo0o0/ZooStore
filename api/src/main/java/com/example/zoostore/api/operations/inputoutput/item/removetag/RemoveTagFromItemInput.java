package com.example.zoostore.api.operations.inputoutput.item.removetag;

import com.example.zoostore.api.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RemoveTagFromItemInput implements OperationInput {

    @NotBlank(message = "item id cannot be blank")
    private String itemId;
    @NotBlank(message = "tag name cannot be blank")
    private String tagTitle;
}
