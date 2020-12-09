package com.study.batch.jpa;

import com.study.batch.dao.service.MemberService;
import com.study.batch.dao.service.OrderService;
import com.study.batch.dto.relation.MemberDTO;
import com.study.batch.dto.relation.OrderDTO;
import com.study.batch.dto.relation.type.RoleType;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;

@Log4j2
@SpringBootTest
@Transactional
public class JpaTest {

    @Autowired
    private MemberService memberService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    /**
     * 연관 관계 매핑 이슈 해결
     **/
    @Test
    public void jpaBasicTest(){
        //when
        List<MemberDTO> memberServiceAll = memberService.findAll();
        memberServiceAll.forEach(memberDTO -> System.out.println(memberDTO.toString()));

//        EntityManager em = entityManagerFactory.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//        try{
//            tx.begin();
//
//            TypedQuery<MemberDTO> query = em.createQuery("select m from MemberDTO m", MemberDTO.class);
//            List<MemberDTO> resultList = query.getResultList();
//            resultList.forEach(i-> System.out.println(i.toString()));
//
//            //then
//            assertThat(resultList).isNotNull();
//            tx.commit();
//        }catch (Exception e){
//            tx.rollback();
//            throw e;
//        }finally {
//            em.close();
//        }
    }

    @Test
    public void jpaInsertTest(){
        //given
        MemberDTO member = MemberDTO.builder()
                .name("BOOK TEST")
                .city("BUSAN")
                .street("SEOGU")
                .zipCode("12345")
                .roleType(RoleType.VIP)
                .orderDTOSet(new HashSet<>())
                .build();
        //then
        memberService.save(member);

        //given
        OrderDTO order = OrderDTO.builder()
                .memberDTO(member) // 연관 관계 편의 메서드를 사용하면 양방향 관계 모두 값 설정 가능 - 개발시 이점
                .orderDate(LocalDateTime.now())
                .build();
        //then
        orderService.save(order);
    }

}
