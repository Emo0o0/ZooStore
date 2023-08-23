package com.example.zoostore.api.operations.inputoutput.vendor.create;

import com.example.zoostore.api.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddVendorOutput implements OperationResult {

    private String id;
}
