package com.example.zoostore.api.operations.inputoutput.item.edit;

import com.example.zoostore.api.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EditItemPropertiesOutput implements OperationResult {

    private String itemId;
    private String description;
    private String productName;
    private String vendorId;
}
