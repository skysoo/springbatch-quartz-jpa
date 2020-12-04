package com.study.batch.dao.repository;

import com.study.batch.dto.ItemDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<ItemDTO, Long> {
}
