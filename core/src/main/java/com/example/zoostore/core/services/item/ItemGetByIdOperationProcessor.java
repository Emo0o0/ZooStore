package com.example.zoostore.core.services.item;

import com.example.zoostore.core.exceptions.item.ItemNotFoundException;
import com.example.zoostore.persistence.entities.Item;
import com.example.zoostore.persistence.repository.ItemRepository;
import com.example.zoostore.api.operations.inputOutput.item.getItemById.GetItemByIdInput;
import com.example.zoostore.api.operations.inputOutput.item.getItemById.GetItemByIdOutput;
import com.example.zoostore.api.operations.inputOutput.item.getItemById.ItemGetByIdOperation;
import com.example.zoostore.api.operations.inputOutput.vendor.getVendorById.MultimediaToDtoSetMap;
import com.example.zoostore.api.operations.inputOutput.vendor.getVendorById.TagsToDtoSetMap;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ItemGetByIdOperationProcessor implements ItemGetByIdOperation {

    private final ItemRepository itemRepository;

    @Override
    public GetItemByIdOutput process(GetItemByIdInput input) {

        if(!itemRepository.existsById(UUID.fromString(input.getId()))){
            throw new ItemNotFoundException("No item with the given id was found");
        }

        Optional<Item> optionalItem = itemRepository.findById(UUID.fromString(input.getId()));
        Item item = optionalItem.get();

        GetItemByIdOutput getItemByIdOutput=GetItemByIdOutput.builder()
                .id(item.getId().toString())
                .title(item.getTitle())
                .description(item.getDescription())
                .archived(item.isArchived())
                .vendorID(item.getVendor().getId().toString())
                .multimedia(MultimediaToDtoSetMap.mapSets(item.getMultimedia()))
                .tags(TagsToDtoSetMap.mapSets(item.getTags()))
                .build();
        return getItemByIdOutput;
    }
}
