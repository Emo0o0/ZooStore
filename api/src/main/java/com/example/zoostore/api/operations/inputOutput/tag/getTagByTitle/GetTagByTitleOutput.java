package com.example.zoostore.api.operations.inputOutput.tag.getTagByTitle;

import com.example.zoostore.api.base.OperationResult;
import com.example.zoostore.api.operations.inputOutput.item.getItemById.GetItemByIdOutput;
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
