package com.example.zoostore.api.operations.inputoutput.tag.getall;

import com.example.zoostore.api.base.OperationResult;
import com.example.zoostore.api.operations.inputoutput.tag.getbytitle.GetTagByTitleOutput;
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
