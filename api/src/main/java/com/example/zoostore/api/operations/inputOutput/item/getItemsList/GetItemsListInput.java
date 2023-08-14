package com.example.zoostore.api.operations.inputOutput.item.getItemsList;

import com.example.zoostore.api.base.OperationInput;
import lombok.*;

import java.util.List;
import java.util.UUID;


@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetItemsListInput implements OperationInput {

    //private List<UUID> ids;
    private List<String> ids;

}
