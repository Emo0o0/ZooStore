package com.example.zoostore.core.services.item;

import com.example.zoostore.api.operations.inputoutput.item.addtag.AddTagToItemInput;
import com.example.zoostore.api.operations.inputoutput.item.addtag.AddTagToItemOutput;
import com.example.zoostore.api.operations.inputoutput.item.addtag.ItemAddTagOperation;
import com.example.zoostore.core.exceptions.item.ItemNotFoundException;
import com.example.zoostore.core.exceptions.tag.TagNotFoundException;
import com.example.zoostore.persistence.entities.Item;
import com.example.zoostore.persistence.entities.Tag;
import com.example.zoostore.persistence.repository.ItemRepository;
import com.example.zoostore.persistence.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ItemAddTagOperationProcessor implements ItemAddTagOperation {

    private final ItemRepository itemRepository;
    private final TagRepository tagRepository;

    @Override
    public AddTagToItemOutput process(AddTagToItemInput input) {

        if (!itemRepository.existsById(UUID.fromString(input.getItemId()))) {
            throw new ItemNotFoundException("No item with the given id was found");
        }
        if (!tagRepository.existsByTitle(input.getTagName())) {
            throw new TagNotFoundException("No tag with the given name was found");
        }

        Optional<Item> optionalItem = itemRepository.findById(UUID.fromString(input.getItemId()));
        Item item = optionalItem.get();
        Tag tag = tagRepository.findByTitle(input.getTagName());
        item.getTags().add(tag);
        itemRepository.save(item);
        AddTagToItemOutput output = AddTagToItemOutput.builder()
                .itemName(item.getTitle())
                .tagName(tag.getTitle())
                .build();
        return output;
    }
}
