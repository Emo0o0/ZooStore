package com.example.zoostore.api.operations.inputoutput.item.archive;

import com.example.zoostore.api.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
