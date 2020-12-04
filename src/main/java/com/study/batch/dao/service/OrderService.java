package com.study.batch.dao.service;

import com.study.batch.dto.OrderDTO;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<OrderDTO> findAll();
    Optional<OrderDTO> findById(Long id);
    void save(OrderDTO orderDTO);
    void deleteById(long id);
}
