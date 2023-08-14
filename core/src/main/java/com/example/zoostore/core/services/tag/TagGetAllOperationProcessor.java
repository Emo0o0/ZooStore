package com.example.zoostore.core.services.tag;

import com.example.zoostore.api.operations.inputOutput.tag.getAllTags.GetAllTagsInput;
import com.example.zoostore.api.operations.inputOutput.tag.getAllTags.GetAllTagsOutput;
import com.example.zoostore.api.operations.inputOutput.tag.getAllTags.TagGetAllOperation;
import com.example.zoostore.api.operations.inputOutput.tag.getTagByTitle.GetTagByTitleOutput;
import com.example.zoostore.persistence.entities.Tag;
import com.example.zoostore.persistence.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TagGetAllOperationProcessor implements TagGetAllOperation {

    private final TagRepository tagRepository;

    @Override
    public GetAllTagsOutput process(GetAllTagsInput input) {
        List<Tag> tagList = tagRepository.findAll();
        GetAllTagsOutput outputList = GetAllTagsOutput.builder().tagList(new ArrayList<>()).build();
        for (Tag tag : tagList) {
            GetTagByTitleOutput output = GetTagByTitleOutput.builder()
                    .title(tag.getTitle())
                    .id(tag.getId().toString())
                    .build();
            outputList.getTagList().add(output);
        }
        return outputList;
    }
}
