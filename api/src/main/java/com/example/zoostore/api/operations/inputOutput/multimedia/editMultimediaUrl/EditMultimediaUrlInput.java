package com.example.zoostore.api.operations.inputOutput.multimedia.editMultimediaUrl;

import com.example.zoostore.api.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EditMultimediaUrlInput implements OperationInput {

    @NotBlank(message = "multimedia id cannot be blank")
    private String id;
    @NotBlank(message = "multimedia url cannot be blank")
    private String url;

}
