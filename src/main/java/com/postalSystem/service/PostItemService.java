package com.postalSystem.service;

import com.postalSystem.dto.PostItemDto;
import com.postalSystem.model.PostItem;
import com.postalSystem.model.PostOffice;

public interface PostItemService {
    PostItem findById(long id);
    void create(PostItemDto postItemDto);
    void sendToPostOffice(PostItem postItem, PostOffice postOffice);
    void arrival(PostItem postItem, PostOffice postOffice);
    void delivery(PostItem postItem);
}
