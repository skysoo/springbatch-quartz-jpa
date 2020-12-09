package com.study.batch.dao.impl;

import com.study.batch.dao.repository.OrderRepository;
import com.study.batch.dao.service.OrderService;
import com.study.batch.dto.relation.OrderDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public List<OrderDTO> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<OrderDTO> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public void save(OrderDTO orderDTO) {
        orderRepository.save(orderDTO);
    }

    @Override
    public void deleteById(long id) {
        orderRepository.deleteById(id);
    }
}
