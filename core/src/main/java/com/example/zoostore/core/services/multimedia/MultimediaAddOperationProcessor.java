package com.example.zoostore.core.services.multimedia;

import com.example.zoostore.core.exceptions.item.ItemNotFoundException;
import com.example.zoostore.persistence.entities.Item;
import com.example.zoostore.persistence.entities.Multimedia;
import com.example.zoostore.persistence.repository.ItemRepository;
import com.example.zoostore.persistence.repository.MultimediaRepository;
import com.example.zoostore.api.operations.inputoutput.multimedia.add.AddMultimediaInput;
import com.example.zoostore.api.operations.inputoutput.multimedia.add.AddMultimediaOutput;
import com.example.zoostore.api.operations.inputoutput.multimedia.add.MultimediaAddOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MultimediaAddOperationProcessor implements MultimediaAddOperation {

    private final MultimediaRepository multimediaRepository;
    private final ItemRepository itemRepository;

    @Override
    public AddMultimediaOutput process(AddMultimediaInput input) {

        if(!itemRepository.existsById(UUID.fromString(input.getItemID()))){
            throw new ItemNotFoundException("No item with the given id was found");
        }

        Optional<Item> optionalItem = itemRepository.findById(UUID.fromString(input.getItemID()));
        Item item = optionalItem.get();

        Multimedia multimedia = Multimedia.builder()
                .url(input.getUrl())
                .item(item)
                .build();
        item.getMultimedia().add(multimedia);

        itemRepository.save(item);
        multimediaRepository.save(multimedia);

        AddMultimediaOutput addMultimediaOutput=AddMultimediaOutput.builder()
                .id(multimedia.getId().toString())
                .build();
        return addMultimediaOutput;
    }
}
