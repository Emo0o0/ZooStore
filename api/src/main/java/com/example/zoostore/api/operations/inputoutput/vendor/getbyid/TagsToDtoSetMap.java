package com.example.zoostore.api.operations.inputoutput.vendor.getbyid;

import com.example.zoostore.api.base.OperationResult;
import lombok.*;
import com.example.zoostore.persistence.entities.Tag;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TagsToDtoSetMap implements OperationResult {
    private String id;
    private String title;

    public static Set<TagsToDtoSetMap> mapSets(Set<Tag> tagSet) {

        Set<TagsToDtoSetMap> outputSet = new HashSet<>();
        for (Tag tag : tagSet) {
            TagsToDtoSetMap output = TagsToDtoSetMap.builder()
                    .id(tag.getId().toString())
                    .title(tag.getTitle())
                    .build();
            outputSet.add(output);
        }
        return outputSet;
    }
}
