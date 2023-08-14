package com.example.zoostore.core.services.tag;

import com.example.zoostore.api.operations.inputOutput.item.getItemById.GetItemByIdOutput;
import com.example.zoostore.api.operations.inputOutput.vendor.getVendorById.MultimediaToDtoSetMap;
import com.example.zoostore.api.operations.inputOutput.vendor.getVendorById.TagsToDtoSetMap;
import com.example.zoostore.core.exceptions.tag.TagNotFoundException;
import com.example.zoostore.persistence.entities.Item;
import com.example.zoostore.persistence.entities.Tag;
import com.example.zoostore.persistence.repository.TagRepository;
import com.example.zoostore.api.operations.inputOutput.tag.getTagByTitle.GetTagByTitleInput;
import com.example.zoostore.api.operations.inputOutput.tag.getTagByTitle.GetTagByTitleOutput;
import com.example.zoostore.api.operations.inputOutput.tag.getTagByTitle.TagGetByTitleOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TagGetByTitleOperationProcessor implements TagGetByTitleOperation {

    private final TagRepository tagRepository;

    @Override
    public GetTagByTitleOutput process(GetTagByTitleInput input) {

        Tag tag = tagRepository.findByTitle(input.getTitle());
        if (tag == null) {
            throw new TagNotFoundException("No tag with the given name was found");
        }

        Set<GetItemByIdOutput> items = new HashSet<>();
        for (Item i : tag.getItems()) {

            GetItemByIdOutput output = GetItemByIdOutput.builder()
                    .id(i.getId().toString())
                    .title(i.getTitle())
                    .description(i.getDescription())
                    .archived(i.isArchived())
                    .vendorID(i.getVendor().getId().toString())
                    .multimedia(MultimediaToDtoSetMap.mapSets(i.getMultimedia()))
                    .tags(TagsToDtoSetMap.mapSets(i.getTags()))
                    .build();
            items.add(output);
        }

        return GetTagByTitleOutput.builder()
                .id(tag.getId().toString())
                .title(tag.getTitle())
                .items(items)
                .build();
    }
}
