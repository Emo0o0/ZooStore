package com.example.zoostore.restexport;

import com.example.zoostore.api.operations.inputOutput.item.getAllItemsByTag.GetAllItemsByTagListOutput;
import com.example.zoostore.api.operations.inputOutput.item.getItemById.GetItemByIdOutput;
import com.example.zoostore.api.operations.inputOutput.item.getItemsList.GetItemsListInput;
import com.example.zoostore.api.operations.inputOutput.item.getItemsList.GetItemsListOutput;
import com.example.zoostore.api.operations.inputOutput.tag.getTagByTitle.GetTagByTitleOutput;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.CollectionFormat;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Headers({"Content-Type: application/json"})
public interface ZooStoreRestClient {

    @RequestLine("GET /item/getById/{id}")
    GetItemByIdOutput getItemById(@Param("id") String id);

    @RequestLine("GET /tag/getByTitle/{title}")
    GetTagByTitleOutput getTagByTitle(@Param("title") String title);

    //@CollectionFormat(feign.CollectionFormat.CSV)
    @RequestLine("POST /item/getList")         //String
    GetItemsListOutput getItemsList(GetItemsListInput input);

    @RequestLine("GET /item/getAllByTag?title={title}&itemsPerPage={itemsPerPage}&currentPage={currentPage}")
    GetAllItemsByTagListOutput getItemsByTag(@Param String title, @Param Integer itemsPerPage, @Param Integer currentPage);

}
