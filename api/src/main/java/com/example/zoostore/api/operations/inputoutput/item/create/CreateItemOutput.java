package com.example.zoostore.api.operations.inputoutput.item.create;

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
