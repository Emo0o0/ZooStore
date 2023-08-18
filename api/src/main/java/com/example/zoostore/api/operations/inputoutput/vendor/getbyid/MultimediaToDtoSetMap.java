package com.example.zoostore.api.operations.inputoutput.vendor.getbyid;

import com.example.zoostore.api.base.OperationResult;
import com.example.zoostore.persistence.entities.Multimedia;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MultimediaToDtoSetMap implements OperationResult {

    private UUID id;

    private String url;

    public static Set<MultimediaToDtoSetMap> mapSets(Set<Multimedia> multimediaSet) {

        Set<MultimediaToDtoSetMap> outputSet = multimediaSet.stream()
                .map(multimedia -> MultimediaToDtoSetMap.builder()
                        .id(multimedia.getId())
                        .url(multimedia.getUrl())
                        .build())
                .collect(Collectors.toSet());

        return outputSet;
    }
}
