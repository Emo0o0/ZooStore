package com.example.zoostore.api.operations.inputOutput.tag.editTagTitle;

import com.example.zoostore.api.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EditTagTitleInput implements OperationInput {

    @NotBlank(message = "tag id cannot be blank")
    private String id;
    @NotBlank(message = "tag title cannot be blank")
    private String title;
}
