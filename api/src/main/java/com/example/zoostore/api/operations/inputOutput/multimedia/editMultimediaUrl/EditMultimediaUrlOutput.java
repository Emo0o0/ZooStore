package com.example.zoostore.api.operations.inputOutput.multimedia.editMultimediaUrl;

import com.example.zoostore.api.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EditMultimediaUrlOutput implements OperationResult {

    private String url;
}
