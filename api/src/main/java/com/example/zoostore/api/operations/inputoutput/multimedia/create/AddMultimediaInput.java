package com.example.zoostore.api.operations.inputoutput.multimedia.create;

import com.example.zoostore.api.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddMultimediaInput implements OperationInput {

    @NotBlank(message = "multimedia url cannot be blank")
    private String url;
    @NotBlank(message = "item id cannot be blank")
    private String itemID;
}
