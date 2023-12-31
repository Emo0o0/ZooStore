package com.example.zoostore.api.operations.inputoutput.item.getallbytag;

import com.example.zoostore.api.base.OperationInput;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetAllItemsByTagInput implements OperationInput {

    private String tagTitle;

    private Integer itemCount;
    private Integer page;
}
