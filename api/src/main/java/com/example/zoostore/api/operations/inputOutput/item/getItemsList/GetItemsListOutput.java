package com.example.zoostore.api.operations.inputOutput.item.getItemsList;

import com.example.zoostore.api.base.OperationResult;
import com.example.zoostore.api.operations.inputOutput.vendor.getVendorById.ItemsToDtoSetMap;
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
