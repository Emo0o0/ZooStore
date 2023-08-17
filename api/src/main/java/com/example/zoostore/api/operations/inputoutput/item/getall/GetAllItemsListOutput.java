package com.example.zoostore.api.operations.inputoutput.item.getall;

import com.example.zoostore.api.base.OperationResult;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetAllItemsListOutput implements OperationResult {

    private List<GetAllItemsOutput> allItemsOutputList;
}
