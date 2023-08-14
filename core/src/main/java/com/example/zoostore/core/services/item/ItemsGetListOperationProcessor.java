package com.example.zoostore.core.services.item;

import com.example.zoostore.api.operations.inputOutput.item.getItemsList.GetItemsListInput;
import com.example.zoostore.api.operations.inputOutput.item.getItemsList.GetItemsListOutput;
import com.example.zoostore.api.operations.inputOutput.item.getItemsList.ItemsGetListOperation;
import com.example.zoostore.api.operations.inputOutput.vendor.getVendorById.ItemsToDtoSetMap;
import com.example.zoostore.api.operations.inputOutput.vendor.getVendorById.MultimediaToDtoSetMap;
import com.example.zoostore.api.operations.inputOutput.vendor.getVendorById.TagsToDtoSetMap;
import com.example.zoostore.persistence.entities.Item;
import com.example.zoostore.persistence.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ItemsGetListOperationProcessor implements ItemsGetListOperation {

    private final ItemRepository itemRepository;
    @Override
    public GetItemsListOutput process(GetItemsListInput input) {

        List<UUID> ids=new ArrayList<>();
        for(String s : input.getIds()){
            ids.add(UUID.fromString(s));
        }

        List<Item> items = itemRepository.getAllByIdIn(ids);
        if (items.isEmpty()) {
            throw new RuntimeException("No ids were passed");
        }
        GetItemsListOutput outputList=GetItemsListOutput
                .builder()
                .itemsList(new ArrayList<>())
                .build();
        for(Item i : items){
            ItemsToDtoSetMap output = ItemsToDtoSetMap.builder()
                    .id(i.getId().toString())
                    .title(i.getTitle())
                    .description(i.getDescription())
                    .archived(i.isArchived())
                    .vendorID(i.getVendor().getId().toString())
                    .multimedia(MultimediaToDtoSetMap.mapSets(i.getMultimedia()))
                    .tags(TagsToDtoSetMap.mapSets(i.getTags()))
                    .build();
            outputList.getItemsList().add(output);
        }

        return outputList;
    }
}
