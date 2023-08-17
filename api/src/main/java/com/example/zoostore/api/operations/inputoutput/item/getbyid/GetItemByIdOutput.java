package com.example.zoostore.api.operations.inputoutput.item.getbyid;

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
public class GetItemByIdOutput implements OperationResult {
    private String id;
    private String title;
    private String description;
    private boolean archived;
    private String vendorID;

    private Set<MultimediaToDtoSetMap> multimedia;

    private Set<TagsToDtoSetMap> tags;

}
