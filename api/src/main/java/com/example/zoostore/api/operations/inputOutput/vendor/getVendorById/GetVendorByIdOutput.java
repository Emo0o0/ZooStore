package com.example.zoostore.api.operations.inputOutput.vendor.getVendorById;

import com.example.zoostore.api.base.OperationResult;
import lombok.*;

import java.util.Set;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetVendorByIdOutput implements OperationResult {
    //kara e qka
    private String id;
    private String name;
    private String phone;
    private Set<ItemsToDtoSetMap> items; //Set ot outputDto
}
