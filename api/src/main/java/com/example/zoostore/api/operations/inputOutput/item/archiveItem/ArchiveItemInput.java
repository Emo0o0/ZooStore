package com.example.zoostore.api.operations.inputOutput.item.archiveItem;

import com.example.zoostore.api.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jdk.dynalink.Operation;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArchiveItemInput implements OperationInput {

    @NotBlank(message = "item id cannot be blank")
    private String id;
    @NotNull
    private boolean archived;
}
