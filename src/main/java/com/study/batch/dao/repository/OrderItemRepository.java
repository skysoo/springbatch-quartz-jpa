package com.study.batch.dao.repository;

import com.study.batch.dto.OrderItemDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItemDTO, Long> {
}
