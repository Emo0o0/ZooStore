package com.example.zoostore.api.operations.inputOutput.item.getAllItemsByTag;

import com.example.zoostore.api.base.OperationResult;
import com.example.zoostore.api.operations.inputOutput.vendor.getVendorById.MultimediaToDtoSetMap;
import com.example.zoostore.api.operations.inputOutput.vendor.getVendorById.TagsToDtoSetMap;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetAllItemsByTagOutput implements OperationResult {

    private String id;
    private String title;
    private String description;
    private String archived;
    private String vendorID;

    private Set<MultimediaToDtoSetMap> multimedia;

    private Set<TagsToDtoSetMap> tags;
}
