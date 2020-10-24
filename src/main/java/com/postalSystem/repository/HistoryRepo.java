package com.postalSystem.repository;

import com.postalSystem.model.History;
import com.postalSystem.model.PostItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepo extends JpaRepository<History,Long> {
    List<History> findByPostItem(PostItem postItem);
}
