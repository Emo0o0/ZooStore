package com.example.zoostore.api.operations.inputoutput.item.removetag;

import com.example.zoostore.api.base.OperationResult;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RemoveTagFromItemOutputList implements OperationResult {
    private List<RemoveTagFromItemOutput> tagList;
}
