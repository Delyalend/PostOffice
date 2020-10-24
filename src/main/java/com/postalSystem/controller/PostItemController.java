package com.postalSystem.controller;

import com.postalSystem.model.History;
import com.postalSystem.model.PostItem;
import com.postalSystem.model.PostOffice;
import com.postalSystem.model.StatusPostItem;
import com.postalSystem.repository.HistoryRepo;
import com.postalSystem.repository.PostItemRepo;
import com.postalSystem.repository.PostOfficeRepo;
import com.postalSystem.service.PostItemService;
import com.postalSystem.service.PostOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;

@RestController
public class PostItemController {

    @Autowired
    private PostItemService postItemService;

    @Autowired
    private PostOfficeService postOfficeService;

    @Autowired
    private PostItemRepo postItemRepo;

    @Autowired
    private PostOfficeRepo postOfficeRepo;

    @Autowired
    private HistoryRepo historyRepo;

    @PostMapping("/postOffices/{postOfficeIndex}/postItems/")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerPostItem(@Valid @RequestBody PostItem postItem, @PathVariable int postOfficeIndex) {
        PostOffice postOffice = postOfficeService.findByIndex(postOfficeIndex);
        postItem.setPostOffice(postOffice);
        postItemRepo.save(postItem);

        String contentHistory = "PostItem was registered";

        History history = History.builder()
                .postItem(postItem)
                .content(contentHistory)
                .date(new Date(new java.util.Date().getTime()))
                .build();

        historyRepo.save(history);

    }

    @PutMapping("postOffices/{postOfficeIndex}/postItems/{postItemId}")
    public void sendPostItem(@PathVariable long postItemId, @PathVariable int postOfficeIndex) {
        PostOffice postOffice = postOfficeService.findByIndex(postOfficeIndex);
        PostItem postItem = postItemService.findById(postItemId);
        postItem.setStatus(StatusPostItem.delivers);
        postItemRepo.save(postItem);

        String contentHistory = "PostItem with id = " +
                postItem.getId() + " send to " +
                postOffice.getName() + " with address = " +
                postOffice.getAddress() + " and index = " +
                postOffice.getIndex();

        History history = History.builder()
                .postItem(postItem)
                .content(contentHistory)
                .date(new Date(new java.util.Date().getTime()))
                .build();

        historyRepo.save(history);

        //записать "такая то посылка отправлена в _"

    }

}
