package com.example.zoostore.rest.controllers;

import com.example.zoostore.api.operations.inputOutput.tag.addTag.AddTagInput;
import com.example.zoostore.api.operations.inputOutput.tag.addTag.AddTagOutput;
import com.example.zoostore.api.operations.inputOutput.tag.editTagTitle.EditTagTitleInput;
import com.example.zoostore.api.operations.inputOutput.tag.editTagTitle.EditTagTitleOutput;
import com.example.zoostore.api.operations.inputOutput.tag.getAllTags.GetAllTagsInput;
import com.example.zoostore.api.operations.inputOutput.tag.getAllTags.GetAllTagsOutput;
import com.example.zoostore.api.operations.inputOutput.tag.getAllTags.TagGetAllOperation;
import com.example.zoostore.api.operations.inputOutput.tag.getTagByTitle.GetTagByTitleInput;
import com.example.zoostore.api.operations.inputOutput.tag.getTagByTitle.GetTagByTitleOutput;
import com.example.zoostore.api.operations.inputOutput.tag.getTagByTitle.TagGetByTitleOperation;
import com.example.zoostore.api.operations.inputOutput.tag.removeTag.RemoveTagInput;
import com.example.zoostore.api.operations.inputOutput.tag.removeTag.RemoveTagOutput;
import com.example.zoostore.api.operations.inputOutput.tag.addTag.TagAddOperation;
import com.example.zoostore.api.operations.inputOutput.tag.editTagTitle.TagEditTitleOperation;
import com.example.zoostore.api.operations.inputOutput.tag.removeTag.TagRemoveOperation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class TagController {

    private final TagAddOperation tagAddOperation;
    private final TagRemoveOperation tagRemoveOperation;
    private final TagEditTitleOperation tagEditTitleOperation;
    private final TagGetByTitleOperation tagGetByTitleOperation;
    private final TagGetAllOperation tagGetAllOperation;


    @PostMapping(path = "tag/add")
    public ResponseEntity<AddTagOutput> addTag(@Valid @RequestBody AddTagInput input) {
        return ResponseEntity.status(200).body(tagAddOperation.process(input));
    }

    @DeleteMapping(path = "tag/remove")
    public ResponseEntity<RemoveTagOutput> removeTag(@Valid @RequestBody RemoveTagInput input) {
        return ResponseEntity.status(200).body(tagRemoveOperation.process(input));
    }

    @PatchMapping(path = "tag/edit_title")
    public ResponseEntity<EditTagTitleOutput> editTag(@Valid @RequestBody EditTagTitleInput input) {
        return ResponseEntity.status(200).body(tagEditTitleOperation.process(input));
    }

    @GetMapping(path = "tag/getByTitle/{title}")
    public ResponseEntity<GetTagByTitleOutput> getTagByTitle(@Valid @PathVariable String title) {
        GetTagByTitleInput input = GetTagByTitleInput.builder().title(title).build();
        return ResponseEntity.status(200).body(tagGetByTitleOperation.process(input));
    }

    @GetMapping(path = "tag/GetAll")
    public ResponseEntity<GetAllTagsOutput> getAllTags(GetAllTagsInput input) {
        return ResponseEntity.status(200).body(tagGetAllOperation.process(input));
    }
}
