package com.example.zoostore.api.operations.inputOutput.item.addTagToItem;

import com.example.zoostore.api.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddTagToItemOutput implements OperationResult {

    private String itemName;
    private String tagName;
}
