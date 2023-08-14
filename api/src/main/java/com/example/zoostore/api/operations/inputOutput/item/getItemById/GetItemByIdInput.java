package com.example.zoostore.api.operations.inputOutput.item.getItemById;

import com.example.zoostore.api.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetItemByIdInput implements OperationInput {

    @NotBlank(message = "item id cannot be blank")
    private String id;

}
