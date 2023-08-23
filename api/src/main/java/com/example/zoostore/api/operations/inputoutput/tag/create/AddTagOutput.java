package com.example.zoostore.api.operations.inputoutput.tag.create;

import com.example.zoostore.api.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddTagOutput implements OperationResult {

    private String title;
    private String id;
}
