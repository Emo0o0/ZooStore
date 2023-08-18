package com.example.zoostore.core.services.item;

import com.example.zoostore.core.exceptions.item.ItemNotFoundException;
import com.example.zoostore.persistence.entities.Item;
import com.example.zoostore.persistence.repository.ItemRepository;
import com.example.zoostore.api.operations.inputoutput.item.archive.ArchiveItemInput;
import com.example.zoostore.api.operations.inputoutput.item.archive.ArchiveItemOutput;
import com.example.zoostore.api.operations.inputoutput.item.archive.ItemArchiveOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ItemArchiveOperationProcessor implements ItemArchiveOperation {

    private final ItemRepository itemRepository;

    @Override
    public ArchiveItemOutput process(ArchiveItemInput input) {

        if (!itemRepository.existsById(UUID.fromString(input.getId()))) {
            throw new ItemNotFoundException("No item with the given id was found");
        }

        Optional<Item> optionalItem = itemRepository.findById(UUID.fromString(input.getId()));
        Item item = optionalItem.get();

        item.setArchived(input.isArchived());
        itemRepository.save(item);

        ArchiveItemOutput output = ArchiveItemOutput.builder()
                .id(item.getId().toString())
                .archived(item.isArchived())
                .build();
        return output;
    }
}
