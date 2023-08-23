package com.example.zoostore.core.services.tag;

import com.example.zoostore.api.operations.inputoutput.item.getbyid.GetItemByIdOutput;
import com.example.zoostore.api.operations.inputoutput.vendor.getbyid.MultimediaToDtoSetMap;
import com.example.zoostore.api.operations.inputoutput.vendor.getbyid.TagsToDtoSetMap;
import com.example.zoostore.core.exceptions.tag.TagNotFoundException;
import com.example.zoostore.persistence.entities.Tag;
import com.example.zoostore.persistence.repository.TagRepository;
import com.example.zoostore.api.operations.inputoutput.tag.getbytitle.GetTagByTitleInput;
import com.example.zoostore.api.operations.inputoutput.tag.getbytitle.GetTagByTitleOutput;
import com.example.zoostore.api.operations.inputoutput.tag.getbytitle.TagGetByTitleOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

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

        Set<GetItemByIdOutput> items = tag.getItems().stream()
                .map(i -> GetItemByIdOutput.builder()
                        .id(i.getId().toString())
                        .title(i.getTitle())
                        .description(i.getDescription())
                        .archived(i.isArchived())
                        .vendorID(i.getVendor().getId().toString())
                        .multimedia(MultimediaToDtoSetMap.mapSets(i.getMultimedia()))
                        .tags(TagsToDtoSetMap.mapSets(i.getTags()))
                        .build())
                .collect(Collectors.toSet());

        return GetTagByTitleOutput.builder()
                .id(tag.getId().toString())
                .title(tag.getTitle())
                .build();
    }
}
