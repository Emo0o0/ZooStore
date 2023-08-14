package com.example.zoostore.api.operations.inputOutput.tag.getAllTags;

import com.example.zoostore.api.base.OperationResult;
import com.example.zoostore.api.operations.inputOutput.tag.getTagByTitle.GetTagByTitleOutput;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetAllTagsOutput implements OperationResult {
    private List<GetTagByTitleOutput> tagList;
}
