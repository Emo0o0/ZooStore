package com.example.zoostore.rest.controllers;

import com.example.zoostore.api.operations.inputoutput.vendor.add.AddVendorInput;
import com.example.zoostore.api.operations.inputoutput.vendor.add.AddVendorOutput;
import com.example.zoostore.api.operations.inputoutput.vendor.add.VendorAddOperation;
import com.example.zoostore.api.operations.inputoutput.vendor.editproperties.EditVendorPropertiesInput;
import com.example.zoostore.api.operations.inputoutput.vendor.editproperties.EditVendorPropertiesOutput;
import com.example.zoostore.api.operations.inputoutput.vendor.editproperties.VendorEditPropertiesOperation;
import com.example.zoostore.api.operations.inputoutput.vendor.getall.GetAllVendorsInput;
import com.example.zoostore.api.operations.inputoutput.vendor.getall.GetAllVendorsOutput;
import com.example.zoostore.api.operations.inputoutput.vendor.getall.VendorGetAllOperation;
import com.example.zoostore.api.operations.inputoutput.vendor.getbyid.GetVendorByIdInput;
import com.example.zoostore.api.operations.inputoutput.vendor.getbyid.GetVendorByIdOutput;
import com.example.zoostore.api.operations.inputoutput.vendor.getbyid.VendorGetByIdOperation;
import com.example.zoostore.api.operations.inputoutput.vendor.remove.RemoveVendorInput;
import com.example.zoostore.api.operations.inputoutput.vendor.remove.RemoveVendorOutput;
import com.example.zoostore.api.operations.inputoutput.vendor.remove.VendorRemoveOperation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@AllArgsConstructor
@RestController
public class VendorController {

    private final VendorAddOperation vendorAddOperation;
    private final VendorRemoveOperation vendorRemoveOperation;
    private final VendorGetByIdOperation vendorGetByIdOperation;
    private final VendorGetAllOperation vendorGetAllOperation;
    private final VendorEditPropertiesOperation vendorEditPropertiesOperation;

    @PostMapping(path = "vendor/add")
    public ResponseEntity<AddVendorOutput> addVendor(@Valid @RequestBody AddVendorInput input) {
        return ResponseEntity.status(200).body(vendorAddOperation.process(input));
    }

    @DeleteMapping(path = "vendor/remove")
    public ResponseEntity<RemoveVendorOutput> addVendor(@Valid @RequestBody RemoveVendorInput input) {
        return ResponseEntity.status(200).body(vendorRemoveOperation.process(input));
    }

    @GetMapping(path = "vendor/getById/{id}")
    public ResponseEntity<GetVendorByIdOutput> getVendorById(@Valid @RequestParam UUID id) {
        GetVendorByIdInput input = GetVendorByIdInput.builder().id(id.toString()).build();
        return ResponseEntity.status(200).body(vendorGetByIdOperation.process(input));
    }

    @GetMapping(path = "vendor/getAll")
    public ResponseEntity<GetAllVendorsOutput> getAllVendors(GetAllVendorsInput input) {
        return ResponseEntity.status(200).body(vendorGetAllOperation.process(input));
    }

    @PatchMapping(path = "vendor/properties")
    public ResponseEntity<EditVendorPropertiesOutput> editVendorProperties(EditVendorPropertiesInput input) {
        return ResponseEntity.status(200).body(vendorEditPropertiesOperation.process(input));
    }
}
