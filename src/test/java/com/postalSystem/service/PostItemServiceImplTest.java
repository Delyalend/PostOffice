package com.postalSystem.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.postalSystem.model.PostItem;
import com.postalSystem.model.PostOffice;
import com.postalSystem.model.StatusPostItem;
import com.postalSystem.model.TypePostItem;
import com.postalSystem.repository.PostItemRepo;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class PostItemServiceImplTest {

    @Autowired
    private PostItemService postItemService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void list() throws JsonProcessingException {
        List<PostItem> list = postItemService.postItems();

        PostItem postItem = PostItem.builder()
                .id(1L)
                .postOffice(new PostOffice())
                .type(TypePostItem.box)
                .status(StatusPostItem.registering)
                .histories(new ArrayList<>())
                .build();

        String json = objectMapper.writeValueAsString(postItem);
        System.out.println(json);

        Assert.assertEquals(list.size(),2);

    }
}