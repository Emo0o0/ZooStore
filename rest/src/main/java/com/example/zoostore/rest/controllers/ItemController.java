package com.example.zoostore.rest.controllers;

import com.example.zoostore.api.operations.inputoutput.item.addtag.AddTagToItemInput;
import com.example.zoostore.api.operations.inputoutput.item.addtag.AddTagToItemOutput;
import com.example.zoostore.api.operations.inputoutput.item.addtag.ItemAddTagOperation;
import com.example.zoostore.api.operations.inputoutput.item.archive.ArchiveItemInput;
import com.example.zoostore.api.operations.inputoutput.item.archive.ArchiveItemOutput;
import com.example.zoostore.api.operations.inputoutput.item.create.CreateItemInput;
import com.example.zoostore.api.operations.inputoutput.item.create.CreateItemOutput;
import com.example.zoostore.api.operations.inputoutput.item.archive.ItemArchiveOperation;
import com.example.zoostore.api.operations.inputoutput.item.create.ItemCreateOperation;
import com.example.zoostore.api.operations.inputoutput.item.edit.EditItemPropertiesInput;
import com.example.zoostore.api.operations.inputoutput.item.edit.EditItemPropertiesOutput;
import com.example.zoostore.api.operations.inputoutput.item.edit.ItemEditPropertiesOperation;
import com.example.zoostore.api.operations.inputoutput.item.getall.GetAllItemsInput;
import com.example.zoostore.api.operations.inputoutput.item.getall.GetAllItemsListOutput;
import com.example.zoostore.api.operations.inputoutput.item.getall.ItemGetAllOperation;
import com.example.zoostore.api.operations.inputoutput.item.getallbytag.GetAllItemsByTagInput;
import com.example.zoostore.api.operations.inputoutput.item.getallbytag.GetAllItemsByTagListOutput;
import com.example.zoostore.api.operations.inputoutput.item.getallbytag.ItemGetAllByTagOperation;
import com.example.zoostore.api.operations.inputoutput.item.getbyid.GetItemByIdInput;
import com.example.zoostore.api.operations.inputoutput.item.getbyid.GetItemByIdOutput;
import com.example.zoostore.api.operations.inputoutput.item.getbyid.ItemGetByIdOperation;
import com.example.zoostore.api.operations.inputoutput.item.getlist.GetItemsListInput;
import com.example.zoostore.api.operations.inputoutput.item.getlist.GetItemsListOutput;
import com.example.zoostore.api.operations.inputoutput.item.getlist.ItemsGetListOperation;
import com.example.zoostore.api.operations.inputoutput.item.removetag.ItemRemoveTagOperation;
import com.example.zoostore.api.operations.inputoutput.item.removetag.RemoveTagFromItemInput;
import com.example.zoostore.api.operations.inputoutput.item.removetag.RemoveTagFromItemOutputList;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
