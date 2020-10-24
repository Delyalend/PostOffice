package com.postalSystem.service;

import com.postalSystem.exception.PostItemNotFoundException;
import com.postalSystem.model.PostItem;
import com.postalSystem.repository.PostItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostItemServiceImpl implements PostItemService {

    @Autowired
    private PostItemRepo postItemRepo;

    @Override
    public List<PostItem> postItems() {
        return postItemRepo.findAll();
    }

    @Override
    public PostItem findById(long id) {
        Optional<PostItem> postItem = postItemRepo.findById(id);
        if(!postItem.isPresent()) {
            throw new PostItemNotFoundException();
        }
        return postItem.get();
    }
}
