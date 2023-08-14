package com.example.zoostore.rest.controllers;

import com.example.zoostore.api.operations.inputOutput.item.addTagToItem.AddTagToItemInput;
import com.example.zoostore.api.operations.inputOutput.item.addTagToItem.AddTagToItemOutput;
import com.example.zoostore.api.operations.inputOutput.item.addTagToItem.ItemAddTagOperation;
import com.example.zoostore.api.operations.inputOutput.item.archiveItem.ArchiveItemInput;
import com.example.zoostore.api.operations.inputOutput.item.archiveItem.ArchiveItemOutput;
import com.example.zoostore.api.operations.inputOutput.item.createItem.CreateItemInput;
import com.example.zoostore.api.operations.inputOutput.item.createItem.CreateItemOutput;
import com.example.zoostore.api.operations.inputOutput.item.archiveItem.ItemArchiveOperation;
import com.example.zoostore.api.operations.inputOutput.item.createItem.ItemCreateOperation;
import com.example.zoostore.api.operations.inputOutput.item.editItemProperties.EditItemPropertiesInput;
import com.example.zoostore.api.operations.inputOutput.item.editItemProperties.EditItemPropertiesOutput;
import com.example.zoostore.api.operations.inputOutput.item.editItemProperties.ItemEditPropertiesOperation;
import com.example.zoostore.api.operations.inputOutput.item.getAllItems.GetAllItemsInput;
import com.example.zoostore.api.operations.inputOutput.item.getAllItems.GetAllItemsListOutput;
import com.example.zoostore.api.operations.inputOutput.item.getAllItems.ItemGetAllOperation;
import com.example.zoostore.api.operations.inputOutput.item.getAllItemsByTag.GetAllItemsByTagInput;
import com.example.zoostore.api.operations.inputOutput.item.getAllItemsByTag.GetAllItemsByTagListOutput;
import com.example.zoostore.api.operations.inputOutput.item.getAllItemsByTag.ItemGetAllByTagOperation;
import com.example.zoostore.api.operations.inputOutput.item.getItemById.GetItemByIdInput;
import com.example.zoostore.api.operations.inputOutput.item.getItemById.GetItemByIdOutput;
import com.example.zoostore.api.operations.inputOutput.item.getItemById.ItemGetByIdOperation;
import com.example.zoostore.api.operations.inputOutput.item.getItemsList.GetItemsListInput;
import com.example.zoostore.api.operations.inputOutput.item.getItemsList.GetItemsListOutput;
import com.example.zoostore.api.operations.inputOutput.item.getItemsList.ItemsGetListOperation;
import com.example.zoostore.api.operations.inputOutput.item.removeTagFromItem.ItemRemoveTagOperation;
import com.example.zoostore.api.operations.inputOutput.item.removeTagFromItem.RemoveTagFromItemInput;
import com.example.zoostore.api.operations.inputOutput.item.removeTagFromItem.RemoveTagFromItemOutputList;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/item")
public class ItemController {
    private final ItemCreateOperation itemCreateOperation;
    private final ItemArchiveOperation itemArchiveOperation;
    private final ItemGetByIdOperation itemGetByIdOperation;
    private final ItemGetAllOperation itemGetAllOperation;
    private final ItemAddTagOperation itemAddTagOperation;
    private final ItemRemoveTagOperation itemRemoveTagOperation;
    private final ItemEditPropertiesOperation itemEditPropertiesOperation;
    private final ItemGetAllByTagOperation itemGetAllByTagOperation;
    private final ItemsGetListOperation itemsGetListOperation;

    @PostMapping(path = "/create")
    public ResponseEntity<CreateItemOutput> createItem(@Valid @RequestBody CreateItemInput input) {
        return ResponseEntity.status(201).body(itemCreateOperation.process(input));
    }

    @PatchMapping(path = "/add_tag")
    public ResponseEntity<AddTagToItemOutput> addTagToItem(@Valid @RequestBody AddTagToItemInput input) {
        return ResponseEntity.status(200).body(itemAddTagOperation.process(input));
    }

    @PatchMapping(path = "/remove_tag")
    public ResponseEntity<RemoveTagFromItemOutputList> removeTagFromItem(@Valid @RequestBody RemoveTagFromItemInput input) {
        return ResponseEntity.status(200).body(itemRemoveTagOperation.process(input));
    }

    @PatchMapping(path = "/properties")
    public ResponseEntity<EditItemPropertiesOutput> editItemProperties(@Valid @RequestBody EditItemPropertiesInput input) {
        return ResponseEntity.status(200).body(itemEditPropertiesOperation.process(input));
    }

    @PatchMapping(path = "/archive")
    public ResponseEntity<ArchiveItemOutput> archiveItem(@Valid @RequestBody ArchiveItemInput input) {
        return ResponseEntity.status(200).body(itemArchiveOperation.process(input));
    }

    @GetMapping(path = "/getById/{id}")
    public ResponseEntity<GetItemByIdOutput> getItemById(@Valid @PathVariable String id) {

        GetItemByIdInput input = GetItemByIdInput.builder().id(id).build();
        return ResponseEntity.status(200).body(itemGetByIdOperation.process(input));
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<GetAllItemsListOutput> getAllItems(@RequestParam GetAllItemsInput input) {
        return ResponseEntity.status(200).body(itemGetAllOperation.process(input));
    }

        @PostMapping(path = "/getList")
    public ResponseEntity<GetItemsListOutput> getItemsList(@RequestBody GetItemsListInput input){
        return ResponseEntity.status(200).body(itemsGetListOperation.process(input));
    }
    //@GetMapping(path = "/getList")                                                //String
    //public ResponseEntity<GetItemsListOutput> getItemsList(@RequestParam(name = "ids") List<String> ids) {
    //    GetItemsListInput input=GetItemsListInput.builder().ids(ids).build();
    //    return ResponseEntity.status(200).body(itemsGetListOperation.process(input));
    //}

    @GetMapping(path = "/getAllByTag")
    public ResponseEntity<GetAllItemsByTagListOutput> getAllItemsByTag(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "itemsPerPage") Integer itemsPerPage,
            @RequestParam(name = "currentPage") Integer currentPage) {

        GetAllItemsByTagInput input = GetAllItemsByTagInput.builder()
                .tagTitle(title)
                .itemCount(itemsPerPage)
                .page(currentPage)
                .build();
        return ResponseEntity.status(200).body(itemGetAllByTagOperation.process(input));
    }
}
