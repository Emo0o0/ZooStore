package com.example.zoostore.api.operations.inputOutput.tag.getTagByTitle;

import com.example.zoostore.api.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetTagByTitleInput implements OperationInput {

    @NotBlank(message = "tag name cannot be blank")
    private String title;

    private Integer itemCount;
    private Integer page;
}
