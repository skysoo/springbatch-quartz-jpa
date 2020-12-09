package com.study.batch.dao.impl;

import com.study.batch.dao.repository.DeliveryRepository;
import com.study.batch.dao.service.DeliveryService;
import com.study.batch.dto.relation.DeliveryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DeliveryServiceImpl implements DeliveryService {
    private final DeliveryRepository deliveryRepository;

    @Override
    public List<DeliveryDTO> findAll() {
        return deliveryRepository.findAll();
    }

    @Override
    public Optional<DeliveryDTO> findById(Long id) {
        return deliveryRepository.findById(id);
    }

    @Override
    public void save(DeliveryDTO deliveryDTO) {
        deliveryRepository.save(deliveryDTO);
    }

    @Override
    public void deleteById(long id) {
        deliveryRepository.deleteById(id);
    }
}
