package com.example.zoostore.core.services.multimedia;

import com.example.zoostore.core.exceptions.item.ItemNotFoundException;
import com.example.zoostore.persistence.entities.Multimedia;
import com.example.zoostore.persistence.repository.MultimediaRepository;
import com.example.zoostore.api.operations.inputOutput.multimedia.removeMultimedia.MultimediaRemoveOperation;
import com.example.zoostore.api.operations.inputOutput.multimedia.removeMultimedia.RemoveMultimediaInput;
import com.example.zoostore.api.operations.inputOutput.multimedia.removeMultimedia.RemoveMultimediaOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MultimediaRemoveOperationProcessor implements MultimediaRemoveOperation {

    private final MultimediaRepository multimediaRepository;

    @Override
    public RemoveMultimediaOutput process(RemoveMultimediaInput input) {

        if(!multimediaRepository.existsById(UUID.fromString(input.getId()))){
            throw new ItemNotFoundException("No multimedia with the given id was found");
        }

        Optional<Multimedia> optionalMultimedia = multimediaRepository.findById(UUID.fromString(input.getId()));
        Multimedia multimedia = optionalMultimedia.get();

        multimediaRepository.delete(multimedia);

        RemoveMultimediaOutput output = RemoveMultimediaOutput.builder()
                .id(input.getId())
                .build();
        return output;
    }
}
