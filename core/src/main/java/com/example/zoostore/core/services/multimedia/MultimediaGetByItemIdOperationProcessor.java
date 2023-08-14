package com.example.zoostore.core.services.multimedia;

import com.example.zoostore.core.exceptions.item.ItemNotFoundException;
import com.example.zoostore.persistence.entities.Item;
import com.example.zoostore.persistence.entities.Multimedia;
import com.example.zoostore.persistence.repository.ItemRepository;
import com.example.zoostore.api.operations.inputOutput.multimedia.getMultiMediaByItemId.GetMultimediaByItemIdInput;
import com.example.zoostore.api.operations.inputOutput.multimedia.getMultiMediaByItemId.GetMultimediaByItemIdOutput;
import com.example.zoostore.api.operations.inputOutput.multimedia.getMultiMediaByItemId.MultimediaGetByItemIdOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MultimediaGetByItemIdOperationProcessor implements MultimediaGetByItemIdOperation {

    private final ItemRepository itemRepository;
    @Override
    public GetMultimediaByItemIdOutput process(GetMultimediaByItemIdInput input) {

        if(!itemRepository.existsById(UUID.fromString(input.getItemId()))){
            throw new ItemNotFoundException("No item with the given id was found");
        }

        Optional<Item> optionalItem = itemRepository.findById(UUID.fromString(input.getItemId()));
        Item item = optionalItem.get();
        Set<String> ids = new HashSet<>();
        Set<String> urls = new HashSet<>();
        for (Multimedia m : item.getMultimedia()) {
            ids.add(m.getId().toString());
            urls.add(m.getUrl());
        }

        GetMultimediaByItemIdOutput output = GetMultimediaByItemIdOutput.builder()
                .id(ids)
                .url(urls)
                .build();

        return output;
    }
}
