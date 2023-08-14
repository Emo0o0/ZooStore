package com.example.zoostore.core.services.item;

import com.example.zoostore.api.operations.inputOutput.item.removeTagFromItem.ItemRemoveTagOperation;
import com.example.zoostore.api.operations.inputOutput.item.removeTagFromItem.RemoveTagFromItemInput;
import com.example.zoostore.api.operations.inputOutput.item.removeTagFromItem.RemoveTagFromItemOutput;
import com.example.zoostore.api.operations.inputOutput.item.removeTagFromItem.RemoveTagFromItemOutputList;
import com.example.zoostore.core.exceptions.item.ItemNotFoundException;
import com.example.zoostore.core.exceptions.tag.TagNotFoundException;
import com.example.zoostore.persistence.entities.Item;
import com.example.zoostore.persistence.entities.Tag;
import com.example.zoostore.persistence.repository.ItemRepository;
import com.example.zoostore.persistence.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.Remove;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ItemRemoveTagOperationProcessor implements ItemRemoveTagOperation {

    private final ItemRepository itemRepository;
    private final TagRepository tagRepository;

    @Override
    public RemoveTagFromItemOutputList process(RemoveTagFromItemInput input) {

        if(!itemRepository.existsById(UUID.fromString(input.getItemId()))){
            throw new ItemNotFoundException("No item with the given id was found");
        }
        if(!tagRepository.existsByTitle(input.getTagTitle())){
            throw new TagNotFoundException("No tag with the given name was found");
        }

        Optional<Item> optionalItem = itemRepository.findById(UUID.fromString(input.getItemId()));
        Item item = optionalItem.get();
        Tag tag = tagRepository.findByTitle(input.getTagTitle());
        item.getTags().remove(tag);
        itemRepository.save(item);
        RemoveTagFromItemOutputList outputList = RemoveTagFromItemOutputList.builder().tagList(new ArrayList<>()).build();
        for (Tag forTag : item.getTags()) {
            RemoveTagFromItemOutput output = RemoveTagFromItemOutput.builder()
                    .tagTitle(forTag.getTitle())
                    .build();
            outputList.getTagList().add(output);
        }
        return outputList;
    }
}
