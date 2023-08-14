package com.example.zoostore.api.operations.inputOutput.multimedia.getMultiMediaByItemId;

import com.example.zoostore.api.base.OperationResult;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetMultimediaByItemIdOutput implements OperationResult {
    private Set<String> id;
    private Set<String> url;

}
