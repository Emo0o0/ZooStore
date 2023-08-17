package com.example.zoostore.api.operations.inputoutput.item.getlist;

import com.example.zoostore.api.base.OperationInput;
import lombok.*;

import java.util.List;


@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetItemsListInput implements OperationInput {

    //private List<UUID> ids;
    private List<String> ids;

}
