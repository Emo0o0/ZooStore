package com.example.zoostore.api.operations.inputOutput.tag.removeTag;

import com.example.zoostore.api.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RemoveTagInput implements OperationInput {

    @NotBlank(message = "tag id cannot be blank")
    private String id;

}
