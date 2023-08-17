package com.example.zoostore.api.operations.inputoutput.item.getallbytag;

import com.example.zoostore.api.base.OperationResult;
import com.example.zoostore.api.operations.inputoutput.vendor.getbyid.MultimediaToDtoSetMap;
import com.example.zoostore.api.operations.inputoutput.vendor.getbyid.TagsToDtoSetMap;
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
