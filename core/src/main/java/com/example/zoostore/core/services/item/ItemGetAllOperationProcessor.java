package com.example.zoostore.core.services.item;

import com.example.zoostore.persistence.entities.Item;
import com.example.zoostore.persistence.repository.ItemRepository;
import com.example.zoostore.api.operations.inputoutput.item.getall.GetAllItemsInput;
import com.example.zoostore.api.operations.inputoutput.item.getall.GetAllItemsListOutput;
import com.example.zoostore.api.operations.inputoutput.item.getall.GetAllItemsOutput;
import com.example.zoostore.api.operations.inputoutput.item.getall.ItemGetAllOperation;
import com.example.zoostore.api.operations.inputoutput.vendor.getbyid.MultimediaToDtoSetMap;
import com.example.zoostore.api.operations.inputoutput.vendor.getbyid.TagsToDtoSetMap;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemGetAllOperationProcessor implements ItemGetAllOperation {

    private final ItemRepository itemRepository;

    @Override
    public GetAllItemsListOutput process(GetAllItemsInput input) {

        List<Item> itemList = itemRepository.findAll();

        GetAllItemsListOutput outputList = GetAllItemsListOutput.builder()
                .allItemsOutputList(itemList.stream()
                        .map(item -> GetAllItemsOutput.builder()
                                .id(item.getId().toString())
                                .title(item.getTitle())
                                .description(item.getDescription())
                                .archived(item.isArchived())
                                .vendorID(item.getVendor().getId().toString())
                                .multimedia(MultimediaToDtoSetMap.mapSets(item.getMultimedia()))
                                .tags(TagsToDtoSetMap.mapSets(item.getTags()))
                                .build())
                        .collect(Collectors.toList()))
                .build();

        return outputList;
    }
}
