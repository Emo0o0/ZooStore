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
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TagGetAllOperationProcessor implements TagGetAllOperation {

    private final TagRepository tagRepository;

    @Override
    public GetAllTagsOutput process(GetAllTagsInput input) {
        List<Tag> tagList = tagRepository.findAll();

        GetAllTagsOutput outputList = GetAllTagsOutput.builder()
                .tagList(tagList.stream()
                        .map(tag -> GetTagByTitleOutput.builder()
                                .title(tag.getTitle())
                                .id(tag.getId().toString())
                                .build())
                        .collect(Collectors.toList()))
                .build();

        return outputList;
    }
}
