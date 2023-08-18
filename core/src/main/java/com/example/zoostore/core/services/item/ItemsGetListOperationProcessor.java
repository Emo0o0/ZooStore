package com.example.zoostore.core.services.item;

import com.example.zoostore.api.operations.inputoutput.item.getlist.GetItemsListInput;
import com.example.zoostore.api.operations.inputoutput.item.getlist.GetItemsListOutput;
import com.example.zoostore.api.operations.inputoutput.item.getlist.ItemsGetListOperation;
import com.example.zoostore.api.operations.inputoutput.vendor.getbyid.ItemsToDtoSetMap;
import com.example.zoostore.api.operations.inputoutput.vendor.getbyid.MultimediaToDtoSetMap;
import com.example.zoostore.api.operations.inputoutput.vendor.getbyid.TagsToDtoSetMap;
import com.example.zoostore.persistence.entities.Item;
import com.example.zoostore.persistence.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemsGetListOperationProcessor implements ItemsGetListOperation {

    private final ItemRepository itemRepository;

    @Override
    public GetItemsListOutput process(GetItemsListInput input) {

        List<UUID> ids = input.getIds().stream()
                .map(UUID::fromString)
                .collect(Collectors.toList());

        List<Item> items = itemRepository.getAllByIdIn(ids);
        if (items.isEmpty()) {
            throw new RuntimeException("No ids were passed");
        }

        GetItemsListOutput outputList = GetItemsListOutput.builder()
                .itemsList(items.stream()
                        .map(i -> ItemsToDtoSetMap.builder()
                                .id(i.getId().toString())
                                .title(i.getTitle())
                                .description(i.getDescription())
                                .archived(i.isArchived())
                                .vendorID(i.getVendor().getId().toString())
                                .multimedia(MultimediaToDtoSetMap.mapSets(i.getMultimedia()))
                                .tags(TagsToDtoSetMap.mapSets(i.getTags()))
                                .build())
                        .collect(Collectors.toList()))
                .build();

        return outputList;
    }
}
