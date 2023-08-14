package com.example.zoostore.core.services.tag;

import com.example.zoostore.persistence.entities.Tag;
import com.example.zoostore.persistence.repository.TagRepository;
import com.example.zoostore.api.operations.inputOutput.tag.addTag.AddTagInput;
import com.example.zoostore.api.operations.inputOutput.tag.addTag.AddTagOutput;
import com.example.zoostore.api.operations.inputOutput.tag.addTag.TagAddOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TagAddOperationProcessor implements TagAddOperation {

    private final TagRepository tagRepository;

    @Override
    public AddTagOutput process(AddTagInput input) {
        Tag tag = Tag.builder()
                .title(input.getTitle())
                .build();

        tagRepository.save(tag);

        AddTagOutput addTagOutput = AddTagOutput.builder()
                .title(tag.getTitle())
                .id(tag.getId().toString())
                .build();
        return addTagOutput;
    }
}
