package com.example.zoostore.api.operations.inputOutput.item.createItem;

import com.example.zoostore.api.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateItemOutput implements OperationResult {
    private String id;

}
