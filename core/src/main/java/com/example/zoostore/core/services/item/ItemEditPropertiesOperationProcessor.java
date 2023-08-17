package com.example.zoostore.core.services.item;

import com.example.zoostore.api.operations.inputoutput.item.edit.EditItemPropertiesInput;
import com.example.zoostore.api.operations.inputoutput.item.edit.EditItemPropertiesOutput;
import com.example.zoostore.api.operations.inputoutput.item.edit.ItemEditPropertiesOperation;
import com.example.zoostore.core.exceptions.item.ItemNotFoundException;
import com.example.zoostore.core.exceptions.vendor.VendorNotFoundException;
import com.example.zoostore.persistence.entities.Item;
import com.example.zoostore.persistence.entities.Vendor;
import com.example.zoostore.persistence.repository.ItemRepository;
import com.example.zoostore.persistence.repository.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class ItemEditPropertiesOperationProcessor implements ItemEditPropertiesOperation {

    private final ItemRepository itemRepository;
    private final VendorRepository vendorRepository;

    @Override
    public EditItemPropertiesOutput process(EditItemPropertiesInput input) {
        if (!itemRepository.existsById(UUID.fromString(input.getItemId()))) {
            throw new ItemNotFoundException("Zoostore/No item with the given id was found");
        }
        if (!vendorRepository.existsById(UUID.fromString(input.getVendorId()))) {
            throw new VendorNotFoundException("No vendor with the given id was found");
        }

        Optional<Item> optionalItem = itemRepository.findById(UUID.fromString(input.getItemId()));
        Item item = optionalItem.get();
        Optional<Vendor> optionalVendor = vendorRepository.findById(UUID.fromString(input.getVendorId()));
        Vendor vendor = optionalVendor.get();

        if (!input.getDescription().isBlank()) {
            item.setDescription(input.getDescription());
        }
        if (!input.getProductName().isBlank()) {
            input.setProductName(input.getProductName());
        }
        item.setVendor(vendor);
        itemRepository.save(item);
        EditItemPropertiesOutput output = EditItemPropertiesOutput.builder()
                .itemId(item.getId().toString())
                .description(item.getDescription())
                .productName(item.getTitle())
                .vendorId(item.getVendor().getId().toString())
                .build();

        return output;
    }
}
