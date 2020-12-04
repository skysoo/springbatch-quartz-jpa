package com.study.batch.dao.service;

import com.study.batch.dto.MemberDTO;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    List<MemberDTO> findAll();
    Optional<MemberDTO> findById(Long id);
    void save(MemberDTO memberDTO);
    void deleteById(long id);
}
