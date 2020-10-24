package com.postalSystem.service;

import com.postalSystem.exception.PostOfficeNotFoundException;
import com.postalSystem.model.PostOffice;
import com.postalSystem.repository.PostOfficeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostOfficeServiceImpl implements PostOfficeService {

    @Autowired
    private PostOfficeRepo postOfficeRepo;

    @Override
    public PostOffice findByIndex(int index) {
        Optional<PostOffice> postOffice = postOfficeRepo.findByIndex(index);
        if (!postOffice.isPresent()) {
            throw new PostOfficeNotFoundException();
        }
        return postOffice.get();
    }

}
