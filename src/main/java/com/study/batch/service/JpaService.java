package com.study.batch.service;

import com.study.batch.dao.ServiceDao;
import com.study.batch.dto.relation.MemberDTO;
import com.study.batch.dto.relation.OrderDTO;
import com.study.batch.dto.relation.type.RoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;

@Service
public class JpaService {
    @Autowired
    private ServiceDao<MemberDTO> memberDao;
    @Autowired
    private ServiceDao<OrderDTO>  orderDao;

    public void insert() {
        MemberDTO member = MemberDTO.builder()
                .name("BOOK TEST")
                .city("BUSAN")
                .street("SEOGU")
                .zipCode("12345")
                .roleType(RoleType.VIP)
                .orderDTOSet(new HashSet<>())
                .build();
        memberDao.save(member);

        OrderDTO order = OrderDTO.builder()
                .memberDTO(member) // 연관 관계 편의 메서드를 사용하면 양방향 관계 모두 값 설정 가능 - 개발시 이점
                .orderDate(LocalDateTime.now())
                .build();
        orderDao.save(order);
    }
}
