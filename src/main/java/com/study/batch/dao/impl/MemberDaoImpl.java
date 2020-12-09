package com.study.batch.dao.impl;

import com.study.batch.dao.ServiceDao;
import com.study.batch.dao.repository.MemberRepository;
import com.study.batch.dto.relation.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberDaoImpl implements ServiceDao<MemberDTO> {
    private final MemberRepository memberRepository;

    @Override
    public List<MemberDTO> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public Optional<MemberDTO> findById(Long id) {
        return memberRepository.findById(id);
    }

    @Override
    public void save(MemberDTO memberDTO) {
        memberRepository.save(memberDTO);
    }

    @Override
    public void deleteById(long id) {
        memberRepository.deleteById(id);
    }
}
