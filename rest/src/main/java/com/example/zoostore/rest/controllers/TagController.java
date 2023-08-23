package com.example.zoostore.rest.controllers;

import com.example.zoostore.api.operations.inputoutput.tag.add.AddTagInput;
import com.example.zoostore.api.operations.inputoutput.tag.add.AddTagOutput;
import com.example.zoostore.api.operations.inputoutput.tag.edittitle.EditTagTitleInput;
import com.example.zoostore.api.operations.inputoutput.tag.edittitle.EditTagTitleOutput;
import com.example.zoostore.api.operations.inputoutput.tag.getall.GetAllTagsInput;
import com.example.zoostore.api.operations.inputoutput.tag.getall.GetAllTagsOutput;
import com.example.zoostore.api.operations.inputoutput.tag.getall.TagGetAllOperation;
import com.example.zoostore.api.operations.inputoutput.tag.getbytitle.GetTagByTitleInput;
import com.example.zoostore.api.operations.inputoutput.tag.getbytitle.GetTagByTitleOutput;
import com.example.zoostore.api.operations.inputoutput.tag.getbytitle.TagGetByTitleOperation;
import com.example.zoostore.api.operations.inputoutput.tag.remove.RemoveTagInput;
import com.example.zoostore.api.operations.inputoutput.tag.remove.RemoveTagOutput;
import com.example.zoostore.api.operations.inputoutput.tag.add.TagAddOperation;
import com.example.zoostore.api.operations.inputoutput.tag.edittitle.TagEditTitleOperation;
import com.example.zoostore.api.operations.inputoutput.tag.remove.TagRemoveOperation;
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
    public ResponseEntity<GetAllTagsOutput> getAllTags() {
        GetAllTagsInput input = GetAllTagsInput.builder().build();
        return ResponseEntity.status(200).body(tagGetAllOperation.process(input));
    }
}
