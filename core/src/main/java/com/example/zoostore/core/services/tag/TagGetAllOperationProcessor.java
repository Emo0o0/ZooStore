package com.example.zoostore.core.services.tag;

import com.example.zoostore.api.operations.inputoutput.tag.getall.GetAllTagsInput;
import com.example.zoostore.api.operations.inputoutput.tag.getall.GetAllTagsOutput;
import com.example.zoostore.api.operations.inputoutput.tag.getall.TagGetAllOperation;
import com.example.zoostore.api.operations.inputoutput.tag.getbytitle.GetTagByTitleOutput;
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
