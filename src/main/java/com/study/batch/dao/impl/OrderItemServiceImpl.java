package com.study.batch.dao.impl;

import com.study.batch.dao.repository.OrderItemRepository;
import com.study.batch.dao.service.OrderItemService;
import com.study.batch.dto.relation.OrderItemDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OrderItemServiceImpl implements OrderItemService {
    private final OrderItemRepository orderItemRepository;

    @Override
    public List<OrderItemDTO> findAll() {
        return orderItemRepository.findAll();
    }

    @Override
    public Optional<OrderItemDTO> findById(Long id) {
        return orderItemRepository.findById(id);
    }

    @Override
    public void save(OrderItemDTO orderItemDTO) {
        orderItemRepository.save(orderItemDTO);
    }

    @Override
    public void deleteById(long id) {
        orderItemRepository.deleteById(id);
    }
}
