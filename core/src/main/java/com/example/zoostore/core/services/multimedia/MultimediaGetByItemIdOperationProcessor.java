package com.example.zoostore.core.services.multimedia;

import com.example.zoostore.core.exceptions.item.ItemNotFoundException;
import com.example.zoostore.persistence.entities.Item;
import com.example.zoostore.persistence.entities.Multimedia;
import com.example.zoostore.persistence.repository.ItemRepository;
import com.example.zoostore.api.operations.inputoutput.multimedia.getbyitemid.GetMultimediaByItemIdInput;
import com.example.zoostore.api.operations.inputoutput.multimedia.getbyitemid.GetMultimediaByItemIdOutput;
import com.example.zoostore.api.operations.inputoutput.multimedia.getbyitemid.MultimediaGetByItemIdOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MultimediaGetByItemIdOperationProcessor implements MultimediaGetByItemIdOperation {

    private final ItemRepository itemRepository;

    @Override
    public GetMultimediaByItemIdOutput process(GetMultimediaByItemIdInput input) {

        if (!itemRepository.existsById(UUID.fromString(input.getItemId()))) {
            throw new ItemNotFoundException("No item with the given id was found");
        }

        Optional<Item> optionalItem = itemRepository.findById(UUID.fromString(input.getItemId()));
        Item item = optionalItem.get();

        GetMultimediaByItemIdOutput output = GetMultimediaByItemIdOutput.builder()
                .id(item.getMultimedia().stream()
                        .map(m -> m.getId().toString())
                        .collect(Collectors.toSet()))
                .url(item.getMultimedia().stream()
                        .map(Multimedia::getUrl)
                        .collect(Collectors.toSet()))
                .build();

        return output;
    }
}
