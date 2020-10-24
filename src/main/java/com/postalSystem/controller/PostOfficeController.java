package com.postalSystem.controller;

import com.postalSystem.exception.PostOfficeAlreadyExists;
import com.postalSystem.model.PostOffice;
import com.postalSystem.repository.PostOfficeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class PostOfficeController {

    @Autowired
    private PostOfficeRepo postOfficeRepo;

    @PostMapping("/postOffices/")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerPostOffice(@Valid @RequestBody PostOffice postOffice) {
        Optional<PostOffice> postOfficeFromDb = postOfficeRepo.findByIndex(postOffice.getIndex());
        if (!postOfficeFromDb.isPresent()) {
            postOfficeRepo.save(postOffice);
        } else {
            throw new PostOfficeAlreadyExists();
        }
    }

}
