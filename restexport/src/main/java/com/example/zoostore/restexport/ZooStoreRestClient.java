package com.example.zoostore.restexport;

import com.example.zoostore.api.operations.inputoutput.item.getallbytag.GetAllItemsByTagListOutput;
import com.example.zoostore.api.operations.inputoutput.item.getbyid.GetItemByIdOutput;
import com.example.zoostore.api.operations.inputoutput.item.getlist.GetItemsListInput;
import com.example.zoostore.api.operations.inputoutput.item.getlist.GetItemsListOutput;
import com.example.zoostore.api.operations.inputoutput.tag.getbytitle.GetTagByTitleOutput;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

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
