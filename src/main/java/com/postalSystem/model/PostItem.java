package com.postalSystem.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostItem {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TypePostItem type;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusPostItem status;

    @ManyToOne(fetch = FetchType.LAZY)
    private PostOffice postOffice;

    @OneToMany(mappedBy = "postItem", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<History> histories;

    public void addHistory(History history) {
        this.histories.add(history);
        history.setPostItem(this);
    }

    public void removeHistory(History history) {
        this.histories.remove(history);
        history.setPostItem(null);
    }



}

