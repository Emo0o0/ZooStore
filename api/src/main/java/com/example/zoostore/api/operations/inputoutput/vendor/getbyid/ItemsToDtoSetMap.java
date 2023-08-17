package com.example.zoostore.api.operations.inputoutput.vendor.getbyid;

import com.example.zoostore.api.base.OperationResult;
import com.example.zoostore.persistence.entities.Item;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemsToDtoSetMap implements OperationResult {
    private String id;
    private String title;
    private String description;
    private boolean archived;
    private String vendorID;

    private Set<MultimediaToDtoSetMap> multimedia;

    private Set<TagsToDtoSetMap> tags;

    public static Set<ItemsToDtoSetMap> mapSets(Set<Item> itemSet) {
        Set<ItemsToDtoSetMap> outputSet = new HashSet<>();
        for (Item item : itemSet) {
            ItemsToDtoSetMap output = ItemsToDtoSetMap.builder()
                    .id(item.getId().toString())
                    .title(item.getTitle())
                    .description(item.getDescription())
                    .archived(item.isArchived())
                    .vendorID(item.getVendor().getId().toString())
                    .multimedia(MultimediaToDtoSetMap.mapSets(item.getMultimedia()))
                    .tags(TagsToDtoSetMap.mapSets(item.getTags()))
                    .build();
            outputSet.add(output);
        }
        return outputSet;
    }
}
