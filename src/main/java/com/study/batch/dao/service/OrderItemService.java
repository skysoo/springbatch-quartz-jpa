package com.study.batch.dao.service;

import com.study.batch.dto.OrderItemDTO;

import java.util.List;
import java.util.Optional;

public interface OrderItemService {
    List<OrderItemDTO> findAll();
    Optional<OrderItemDTO> findById(Long id);
    void save(OrderItemDTO orderItemDTO);
    void deleteById(long id);
}
