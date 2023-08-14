package com.example.zoostore.api.operations.inputOutput.item.archiveItem;

import com.example.zoostore.api.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArchiveItemOutput implements OperationResult {

    private String id;
    private boolean archived;
}
