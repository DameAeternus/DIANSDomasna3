package com.example.demo.repository;

import com.example.demo.model.Winery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WineryRepository extends JpaRepository<Winery, Long> {
    List<Winery> findByName(String name);
}
