package com.example.zoostore.api.operations.inputoutput.item.getlist;

import com.example.zoostore.api.base.OperationResult;
import com.example.zoostore.api.operations.inputoutput.vendor.getbyid.ItemsToDtoSetMap;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetItemsListOutput implements OperationResult {

    private List<ItemsToDtoSetMap> itemsList;

}
