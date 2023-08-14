package com.example.zoostore.api.operations.inputOutput.tag.editTagTitle;

import com.example.zoostore.api.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EditTagTitleOutput implements OperationResult {

    private String title;
}
