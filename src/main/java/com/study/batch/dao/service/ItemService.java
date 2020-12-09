package com.study.batch.dao.service;

import com.study.batch.dto.relation.ItemDTO;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    List<ItemDTO> findAll();
    Optional<ItemDTO> findById(Long id);
    void save(ItemDTO itemDTO);
    void deleteById(long id);
}
