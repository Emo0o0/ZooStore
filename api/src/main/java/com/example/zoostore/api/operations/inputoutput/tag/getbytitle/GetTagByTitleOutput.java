package com.example.zoostore.api.operations.inputoutput.tag.getbytitle;

import com.example.zoostore.api.base.OperationResult;
import com.example.zoostore.api.operations.inputoutput.item.getbyid.GetItemByIdOutput;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetTagByTitleOutput implements OperationResult {

    private String id;
    private String title;
    private Set<GetItemByIdOutput> items;
}
