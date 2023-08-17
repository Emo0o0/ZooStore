package com.example.zoostore.api.operations.inputoutput.vendor.getbyid;

import com.example.zoostore.api.base.OperationResult;
import com.example.zoostore.persistence.entities.Multimedia;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MultimediaToDtoSetMap implements OperationResult {

    private UUID id;

    private String url;

    public static Set<MultimediaToDtoSetMap> mapSets(Set<Multimedia> multimediaSet){
        Set<MultimediaToDtoSetMap> outputSet=new HashSet<>();
        for(Multimedia multimedia : multimediaSet){

            MultimediaToDtoSetMap output= MultimediaToDtoSetMap.builder()
                    .id(multimedia.getId())
                    .url(multimedia.getUrl())
                    .build();

            outputSet.add(output);
        }

        return outputSet;
    }
}
