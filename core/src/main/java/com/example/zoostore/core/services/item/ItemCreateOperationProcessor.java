package com.example.zoostore.core.services.item;

import com.example.zoostore.core.exceptions.vendor.VendorNotFoundException;
import com.example.zoostore.persistence.entities.Item;
import com.example.zoostore.persistence.entities.Vendor;
import com.example.zoostore.persistence.repository.ItemRepository;
import com.example.zoostore.persistence.repository.VendorRepository;
import com.example.zoostore.api.operations.inputoutput.item.create.CreateItemInput;
import com.example.zoostore.api.operations.inputoutput.item.create.CreateItemOutput;
import com.example.zoostore.api.operations.inputoutput.item.create.ItemCreateOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ItemCreateOperationProcessor implements ItemCreateOperation {

    private final ItemRepository itemRepository;
    private final VendorRepository vendorRepository;


    @Override
    public CreateItemOutput process(CreateItemInput input) {

        if(!vendorRepository.existsById(UUID.fromString(input.getVendorID()))){
            throw new VendorNotFoundException("No vendor with the given id was found");
        }

        Optional<Vendor> optionalVendor = vendorRepository.findById(UUID.fromString(input.getVendorID()));
        Vendor vendor = optionalVendor.get();

        Item item = Item.builder()
                .title(input.getTitle())
                .description(input.getDescription())
                .vendor(vendor)
                .build();

        itemRepository.save(item);

        CreateItemOutput createItemOutput = CreateItemOutput.builder()
                .id(item.getId().toString())
                .build();

        return createItemOutput;
    }
}