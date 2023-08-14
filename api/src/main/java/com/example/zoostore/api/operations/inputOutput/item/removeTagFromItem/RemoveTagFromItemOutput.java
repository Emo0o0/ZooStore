package com.example.zoostore.api.operations.inputOutput.item.removeTagFromItem;

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
