package com.example.zoostore.api.operations.inputoutput.item.getallbytag;

import com.example.zoostore.api.base.OperationResult;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetAllItemsByTagListOutput implements OperationResult {

    private Set<GetAllItemsByTagOutput> items;
}
