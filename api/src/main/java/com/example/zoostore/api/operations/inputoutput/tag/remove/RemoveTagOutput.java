package com.example.zoostore.api.operations.inputoutput.tag.remove;

import com.example.zoostore.api.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RemoveTagOutput implements OperationResult {

    private String id;
}
