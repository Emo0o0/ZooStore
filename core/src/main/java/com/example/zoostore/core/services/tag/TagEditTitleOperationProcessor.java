package com.example.zoostore.core.services.tag;

import com.example.zoostore.core.exceptions.item.ItemNotFoundException;
import com.example.zoostore.persistence.entities.Tag;
import com.example.zoostore.persistence.repository.TagRepository;
import com.example.zoostore.api.operations.inputoutput.tag.edittitle.EditTagTitleInput;
import com.example.zoostore.api.operations.inputoutput.tag.edittitle.EditTagTitleOutput;
import com.example.zoostore.api.operations.inputoutput.tag.edittitle.TagEditTitleOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TagEditTitleOperationProcessor implements TagEditTitleOperation {

    private final TagRepository tagRepository;

    @Override
    public EditTagTitleOutput process(EditTagTitleInput input) {

        if(!tagRepository.existsById(UUID.fromString(input.getId()))){
            throw new ItemNotFoundException("No tag with the given id was found");
        }

        Optional<Tag> optionalTag = tagRepository.findById(UUID.fromString(input.getId()));
        Tag tag = optionalTag.get();
        tag.setTitle(input.getTitle());
        tagRepository.save(tag);
        EditTagTitleOutput output=EditTagTitleOutput.builder()
                .title(tag.getTitle())
                .build();
        return output;
    }
}
