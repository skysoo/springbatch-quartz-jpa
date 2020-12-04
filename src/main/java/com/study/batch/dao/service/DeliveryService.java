package com.study.batch.dao.service;

import com.study.batch.dto.DeliveryDTO;

import java.util.List;
import java.util.Optional;

public interface DeliveryService {
    List<DeliveryDTO> findAll();
    Optional<DeliveryDTO> findById(Long id);
    void save(DeliveryDTO deliveryDTO);
    void deleteById(long id);
}
