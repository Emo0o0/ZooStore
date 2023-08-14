package com.example.zoostore.core.services.item;

import com.example.zoostore.api.operations.inputOutput.item.getAllItemsByTag.GetAllItemsByTagInput;
import com.example.zoostore.api.operations.inputOutput.item.getAllItemsByTag.GetAllItemsByTagListOutput;
import com.example.zoostore.api.operations.inputOutput.item.getAllItemsByTag.GetAllItemsByTagOutput;
import com.example.zoostore.api.operations.inputOutput.item.getAllItemsByTag.ItemGetAllByTagOperation;
import com.example.zoostore.api.operations.inputOutput.item.getItemById.GetItemByIdOutput;
import com.example.zoostore.api.operations.inputOutput.tag.getTagByTitle.GetTagByTitleOutput;
import com.example.zoostore.api.operations.inputOutput.vendor.getVendorById.ItemsToDtoSetMap;
import com.example.zoostore.core.exceptions.tag.TagNotFoundException;
import com.example.zoostore.persistence.entities.Tag;
import com.example.zoostore.persistence.repository.ItemRepository;
import com.example.zoostore.persistence.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ItemGetAllByTagOperationProcessor implements ItemGetAllByTagOperation {

    private final ItemRepository itemRepository;
    private final TagRepository tagRepository;
    @Override
    public GetAllItemsByTagListOutput process(GetAllItemsByTagInput input) {

        Tag tag = tagRepository.findByTitle(input.getTagTitle());
        if (tag == null) {
            throw new TagNotFoundException("No tag with the given name was found");
        }

        PageRequest pageRequest = PageRequest.of(input.getPage() - 1, input.getItemCount());
        Set<ItemsToDtoSetMap> itemsList = ItemsToDtoSetMap.mapSets(new HashSet<>(itemRepository.findItemByTagsContaining(tag, pageRequest).getContent()));


        Set<GetAllItemsByTagOutput> outputs=new HashSet<>();
        for (ItemsToDtoSetMap i : itemsList) {

            GetAllItemsByTagOutput output = GetAllItemsByTagOutput.builder()
                    .id(i.getId().toString())
                    .title(i.getTitle())
                    .description(i.getDescription())
                    .archived(String.valueOf(i.isArchived()))
                    .vendorID(i.getVendorID())
                    .multimedia(i.getMultimedia())
                    .tags(i.getTags())
                    .build();
            outputs.add(output);
        }

        return GetAllItemsByTagListOutput.builder()
                .items(outputs)
                .build();


    }
}
