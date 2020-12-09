package com.study.batch.dao.repository;

import com.study.batch.dto.relation.MemberDTO;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

@Service
public class MemberRepositoryImpl implements MyJpaRepository<MemberDTO> {
    private final EntityManagerFactory entityManagerFactory;

    public MemberRepositoryImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public MemberDTO findById(long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        MemberDTO memberDTO = null;
        try {
            transaction.begin();

            memberDTO = entityManager.find(MemberDTO.class, id);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }

        return memberDTO;
    }
    @Override
    public List<MemberDTO> findByAll() {
        return null;
    }

    @Override
    public List<MemberDTO> findByAllWithSort(Sort sort) {
        return null;
    }

    @Override
    public void save(MemberDTO memberDTO) {

    }

    @Override
    public void saveAndFlush(MemberDTO memberDTO) {

    }

    @Override
    public void deleteById(long id) {

    }
}
