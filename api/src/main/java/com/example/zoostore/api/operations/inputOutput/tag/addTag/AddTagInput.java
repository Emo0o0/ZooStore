package com.example.zoostore.api.operations.inputOutput.tag.addTag;

import com.example.zoostore.api.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddTagInput implements OperationInput {

    @NotBlank(message = "tag title cannot be blank")
    private String title;

}
