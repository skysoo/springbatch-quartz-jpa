package com.study.batch.dao.repository;

import com.study.batch.dto.relation.OrderDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderDTO, Long> {
}
