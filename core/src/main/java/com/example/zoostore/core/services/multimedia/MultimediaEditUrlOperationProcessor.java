package com.example.zoostore.core.services.multimedia;

import com.example.zoostore.core.exceptions.item.ItemNotFoundException;
import com.example.zoostore.persistence.entities.Multimedia;
import com.example.zoostore.persistence.repository.MultimediaRepository;
import com.example.zoostore.api.operations.inputoutput.multimedia.editurl.EditMultimediaUrlInput;
import com.example.zoostore.api.operations.inputoutput.multimedia.editurl.EditMultimediaUrlOutput;
import com.example.zoostore.api.operations.inputoutput.multimedia.editurl.MultimediaEditUrlOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MultimediaEditUrlOperationProcessor implements MultimediaEditUrlOperation {

    private final MultimediaRepository multimediaRepository;

    @Override
    public EditMultimediaUrlOutput process(EditMultimediaUrlInput input) {

        if(!multimediaRepository.existsById(UUID.fromString(input.getId()))){
            throw new ItemNotFoundException("No multimedia with the given id was found");
        }

        Optional<Multimedia> optionalMultimedia = multimediaRepository.findById(UUID.fromString(input.getId()));
        Multimedia multimedia = optionalMultimedia.get();
        multimedia.setUrl(input.getUrl());
        multimediaRepository.save(multimedia);
        EditMultimediaUrlOutput output = EditMultimediaUrlOutput.builder()
                .url(multimedia.getUrl())
                .build();
        return output;
    }
}
