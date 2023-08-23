package com.example.zoostore.api.operations.inputoutput.multimedia.create;

import com.example.zoostore.api.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddMultimediaOutput implements OperationResult {
    private String id;

}
