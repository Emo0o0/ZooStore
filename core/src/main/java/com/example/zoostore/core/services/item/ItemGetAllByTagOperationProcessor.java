package com.example.zoostore.core.services.item;

import com.example.zoostore.api.operations.inputoutput.item.getallbytag.GetAllItemsByTagInput;
import com.example.zoostore.api.operations.inputoutput.item.getallbytag.GetAllItemsByTagListOutput;
import com.example.zoostore.api.operations.inputoutput.item.getallbytag.GetAllItemsByTagOutput;
import com.example.zoostore.api.operations.inputoutput.item.getallbytag.ItemGetAllByTagOperation;
import com.example.zoostore.api.operations.inputoutput.vendor.getbyid.ItemsToDtoSetMap;
import com.example.zoostore.core.exceptions.tag.TagNotFoundException;
import com.example.zoostore.persistence.entities.Tag;
import com.example.zoostore.persistence.repository.ItemRepository;
import com.example.zoostore.persistence.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemGetAllByTagOperationProcessor implements ItemGetAllByTagOperation {

    private final ItemRepository itemRepository;
    private final TagRepository tagRepository;
    @Override
    public GetAllItemsByTagListOutput process(GetAllItemsByTagInput input) {

        Tag tag = tagRepository.findByTitle(input.getTagTitle());
        if (tag == null) {
            throw new TagNotFoundException("No tag with the given name was found");
        }

        PageRequest pageRequest = PageRequest.of(input.getPage() - 1, input.getItemCount());
        Set<ItemsToDtoSetMap> itemsList = ItemsToDtoSetMap.mapSets(new HashSet<>(itemRepository.findItemByTagsContaining(tag, pageRequest).getContent()));


        Set<GetAllItemsByTagOutput> outputs = itemsList.stream()
                .map(i -> GetAllItemsByTagOutput.builder()
                        .id(i.getId().toString())
                        .title(i.getTitle())
                        .description(i.getDescription())
                        .archived(String.valueOf(i.isArchived()))
                        .vendorID(i.getVendorID())
                        .multimedia(i.getMultimedia())
                        .tags(i.getTags())
                        .build())
                .collect(Collectors.toSet());

        return GetAllItemsByTagListOutput.builder()
                .items(outputs)
                .build();


    }
}
