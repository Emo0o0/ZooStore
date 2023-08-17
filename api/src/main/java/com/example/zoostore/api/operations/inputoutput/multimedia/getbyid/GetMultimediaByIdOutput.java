package com.example.zoostore.api.operations.inputoutput.multimedia.getbyid;

import com.example.zoostore.api.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetMultimediaByIdOutput implements OperationResult {
    private String id;
    private String url;
    private String itemId;
}
