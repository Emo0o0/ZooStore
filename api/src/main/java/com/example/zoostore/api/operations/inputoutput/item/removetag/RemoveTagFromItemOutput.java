package com.example.zoostore.api.operations.inputoutput.item.removetag;

import com.example.zoostore.api.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RemoveTagFromItemOutput implements OperationResult {
    private String tagTitle;
}
