package com.example.demo.service;

import com.example.demo.model.Wine;
import com.example.demo.model.Winery;

import java.util.List;
import java.util.Optional;

public interface WineService {

            List<Wine> findAll();

            Optional<Wine> findById(Long id);

            void deleteById(Long id);

            Wine save(String name, Integer year, String description, Long wineryId);

            Wine edit(Long id, String name, Integer year, String description, Long wineryId);

            void addWineToWinery(Wine wine, Winery winery);

             Wine save(Wine wine);
             List<Wine> search(String query);
}
