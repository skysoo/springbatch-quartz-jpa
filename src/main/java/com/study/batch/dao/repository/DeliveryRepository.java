package com.study.batch.dao.repository;

import com.study.batch.dto.relation.DeliveryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends JpaRepository<DeliveryDTO, Long> {
}
