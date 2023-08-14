package com.example.zoostore.rest.controllers;

import com.example.zoostore.api.operations.inputOutput.multimedia.addMultimedia.AddMultimediaInput;
import com.example.zoostore.api.operations.inputOutput.multimedia.addMultimedia.AddMultimediaOutput;
import com.example.zoostore.api.operations.inputOutput.multimedia.editMultimediaUrl.EditMultimediaUrlInput;
import com.example.zoostore.api.operations.inputOutput.multimedia.editMultimediaUrl.EditMultimediaUrlOutput;
import com.example.zoostore.api.operations.inputOutput.multimedia.getMultiMediaByItemId.GetMultimediaByItemIdInput;
import com.example.zoostore.api.operations.inputOutput.multimedia.getMultiMediaByItemId.GetMultimediaByItemIdOutput;
import com.example.zoostore.api.operations.inputOutput.multimedia.getMultimediaById.GetMultimediaByIdInput;
import com.example.zoostore.api.operations.inputOutput.multimedia.getMultimediaById.GetMultimediaByIdOutput;
import com.example.zoostore.api.operations.inputOutput.multimedia.getMultimediaById.MultimediaGetByIdOperation;
import com.example.zoostore.api.operations.inputOutput.multimedia.removeMultimedia.RemoveMultimediaInput;
import com.example.zoostore.api.operations.inputOutput.multimedia.removeMultimedia.RemoveMultimediaOutput;
import com.example.zoostore.api.operations.inputOutput.multimedia.addMultimedia.MultimediaAddOperation;
import com.example.zoostore.api.operations.inputOutput.multimedia.editMultimediaUrl.MultimediaEditUrlOperation;
import com.example.zoostore.api.operations.inputOutput.multimedia.removeMultimedia.MultimediaRemoveOperation;
import com.example.zoostore.core.services.multimedia.MultimediaGetByItemIdOperationProcessor;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@AllArgsConstructor
@RestController
public class MultimediaController {

    private final MultimediaAddOperation multimediaAddOperation;
    private final MultimediaRemoveOperation multimediaRemoveOperation;
    private final MultimediaEditUrlOperation multimediaEditUrlOperation;
    private final MultimediaGetByIdOperation multimediaGetByIdOperation;
    private final MultimediaGetByItemIdOperationProcessor multimediaGetByItemIdService;


    @PostMapping(path = "multimedia/add")
    public ResponseEntity<AddMultimediaOutput> addMultimedia(@Valid @RequestBody AddMultimediaInput input) {
        return ResponseEntity.status(200).body(multimediaAddOperation.process(input));
    }

    @DeleteMapping(path = "multimedia/remove")
    public ResponseEntity<RemoveMultimediaOutput> removeMultimedia(@Valid @RequestBody RemoveMultimediaInput input) {
        return ResponseEntity.status(200).body(multimediaRemoveOperation.process(input));
    }

    @PostMapping(path = "multimedia/edit_url")
    public ResponseEntity<EditMultimediaUrlOutput> editMultimediaUrl(@Valid @RequestBody EditMultimediaUrlInput input) {
        return ResponseEntity.status(200).body(multimediaEditUrlOperation.process(input));
    }

    @GetMapping(path = "multimedia/getById/{id}")
    public ResponseEntity<GetMultimediaByIdOutput> getMultimediaById(@Valid @RequestParam UUID id) {
        GetMultimediaByIdInput input = GetMultimediaByIdInput.builder().id(id.toString()).build();
        return ResponseEntity.status(200).body(multimediaGetByIdOperation.process(input));
    }

    @GetMapping(path = "multimedia/getByItemId/{id}")
    public ResponseEntity<GetMultimediaByItemIdOutput> getMultimediaByItemId(@Valid @RequestParam UUID id) {
        GetMultimediaByItemIdInput input = GetMultimediaByItemIdInput.builder().itemId(id.toString()).build();
        return ResponseEntity.status(200).body(multimediaGetByItemIdService.process(input));
    }
}
