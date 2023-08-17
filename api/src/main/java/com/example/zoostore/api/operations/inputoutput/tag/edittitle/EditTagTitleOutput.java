package com.example.zoostore.api.operations.inputoutput.tag.edittitle;

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
