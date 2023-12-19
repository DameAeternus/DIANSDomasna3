package com.example.demo.repository;

import com.example.demo.model.Wine;
import com.example.demo.model.Winery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WineRepository extends JpaRepository<Wine, Long> {
    List<Wine> findByName(String name);
    List<Wine> search(String query);
}
