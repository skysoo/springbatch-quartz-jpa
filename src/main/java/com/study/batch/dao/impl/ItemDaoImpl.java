package com.study.batch.dao.impl;

import com.study.batch.dao.ServiceDao;
import com.study.batch.dao.repository.ItemRepository;
import com.study.batch.dto.relation.ItemDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ItemDaoImpl implements ServiceDao<ItemDTO> {
    private final ItemRepository itemRepository;

    @Override
    public List<ItemDTO> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public Optional<ItemDTO> findById(Long id) {
        return itemRepository.findById(id);
    }

    @Override
    public void save(ItemDTO itemDTO) {
        itemRepository.save(itemDTO);
    }

    @Override
    public void deleteById(long id) {
        itemRepository.deleteById(id);
    }
}
