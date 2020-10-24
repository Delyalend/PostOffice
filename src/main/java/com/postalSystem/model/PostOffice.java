package com.postalSystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostOffice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int index;

    @Column(length = 250, nullable = false)
    private String address;

    @Column(length = 250, nullable = false)
    private String name;

    @OneToMany(mappedBy = "postOffice", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PostItem> postItemList = new ArrayList<>();

    public void addPostItem(PostItem postItem) {
        this.postItemList.add(postItem);
        postItem.setPostOffice(this);
    }

    public void removePostItem(PostItem postItem) {
        this.postItemList.remove(postItem);
        postItem.setPostOffice(null);
    }



}