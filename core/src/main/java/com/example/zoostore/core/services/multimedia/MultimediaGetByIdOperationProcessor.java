package com.example.zoostore.core.services.multimedia;

import com.example.zoostore.core.exceptions.item.ItemNotFoundException;
import com.example.zoostore.persistence.entities.Multimedia;
import com.example.zoostore.persistence.repository.MultimediaRepository;
import com.example.zoostore.api.operations.inputOutput.multimedia.getMultimediaById.GetMultimediaByIdInput;
import com.example.zoostore.api.operations.inputOutput.multimedia.getMultimediaById.GetMultimediaByIdOutput;
import com.example.zoostore.api.operations.inputOutput.multimedia.getMultimediaById.MultimediaGetByIdOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MultimediaGetByIdOperationProcessor implements MultimediaGetByIdOperation {
    private final MultimediaRepository multimediaRepository;

    @Override
    public GetMultimediaByIdOutput process(GetMultimediaByIdInput input) {

        if(!multimediaRepository.existsById(UUID.fromString(input.getId()))){
            throw new ItemNotFoundException("No multimedia with the given id was found");
        }

        Optional<Multimedia> optionalMultimedia = multimediaRepository.findById(UUID.fromString(input.getId()));

        Multimedia multimedia = optionalMultimedia.get();

        return GetMultimediaByIdOutput.builder()
                .id(multimedia.getId().toString())
                .url(multimedia.getUrl())
                .itemId(multimedia.getItem().getId().toString())
                .build();
    }
}


