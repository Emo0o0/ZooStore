package com.example.zoostore.api.operations.inputoutput.multimedia.remove;

import com.example.zoostore.api.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RemoveMultimediaInput implements OperationInput {

    @NotBlank(message = "multimedia id cannot be blank")
    private String id;
}
