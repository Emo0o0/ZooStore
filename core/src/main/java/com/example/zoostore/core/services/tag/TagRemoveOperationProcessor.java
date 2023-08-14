package com.example.zoostore.core.services.tag;

import com.example.zoostore.core.exceptions.item.ItemNotFoundException;
import com.example.zoostore.persistence.entities.Tag;
import com.example.zoostore.persistence.repository.TagRepository;
import com.example.zoostore.api.operations.inputOutput.tag.removeTag.RemoveTagInput;
import com.example.zoostore.api.operations.inputOutput.tag.removeTag.RemoveTagOutput;
import com.example.zoostore.api.operations.inputOutput.tag.removeTag.TagRemoveOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TagRemoveOperationProcessor implements TagRemoveOperation {

    private final TagRepository tagRepository;

    @Override
    public RemoveTagOutput process(RemoveTagInput input) {

        if(!tagRepository.existsById(UUID.fromString(input.getId()))){
            throw new ItemNotFoundException("No tag with the given id was found");
        }

        Optional<Tag> optionalTag = tagRepository.findById(UUID.fromString(input.getId()));
        Tag tag = optionalTag.get();
        tagRepository.delete(tag);
        RemoveTagOutput output = RemoveTagOutput.builder()
                .id(tag.getId().toString())
                .build();
        return output;
    }
}
