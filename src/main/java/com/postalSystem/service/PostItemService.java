package com.postalSystem.service;

import com.postalSystem.model.PostItem;

import java.util.List;

public interface PostItemService {

    List<PostItem> postItems();

    PostItem findById(long id);


}
