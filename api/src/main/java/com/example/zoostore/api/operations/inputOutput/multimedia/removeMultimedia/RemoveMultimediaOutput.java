package com.example.zoostore.api.operations.inputOutput.multimedia.removeMultimedia;

import com.example.zoostore.api.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RemoveMultimediaOutput implements OperationResult {

    private String id;
}
