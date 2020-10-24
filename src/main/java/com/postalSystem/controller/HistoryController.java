package com.postalSystem.controller;

import com.postalSystem.model.History;
import com.postalSystem.model.PostItem;
import com.postalSystem.repository.HistoryRepo;
import com.postalSystem.service.PostItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HistoryController {

    @Autowired
    private HistoryRepo historyRepo;

    @Autowired
    private PostItemService postItemService;

    @GetMapping("postItems/{postItemId}/histories")
    public @ResponseBody
    List<History> getHistories(@PathVariable Long postItemId) {
        PostItem postItem = postItemService.findById(postItemId);
        System.out.println("Я тут!");
        return historyRepo.findByPostItem(postItem);
    }

}
