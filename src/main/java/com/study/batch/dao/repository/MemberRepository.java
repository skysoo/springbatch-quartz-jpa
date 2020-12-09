package com.study.batch.dao.repository;

import com.study.batch.dto.relation.MemberDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberDTO, Long> {
}
