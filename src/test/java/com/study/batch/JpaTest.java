package com.study.batch;

import com.study.batch.dao.service.*;
import com.study.batch.dto.DeliveryDTO;
import com.study.batch.dto.MemberDTO;
import com.study.batch.dto.OrderDTO;
import com.study.batch.dto.type.RoleType;
import com.study.batch.dto.type.StatusType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.HashSet;

@SpringBootTest
public class JpaTest {
    @Autowired
    private  OrderService orderService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private OrderItemService orderItemService;
    @Autowired
    private DeliveryService deliveryService;
    @Autowired
    private ItemService itemService;

    @Test
    void insertTest(){
        //given
        MemberDTO memberDTO  = MemberDTO.builder()
                .name("PSS")
                .city("SEOUL")
                .street("TTUKSUM")
                .zipCode("50508")
                .roleType(RoleType.VIP)
                .orderDTOSet(new HashSet<>())
                .build();

        //given
        DeliveryDTO deliveryDTO = DeliveryDTO.builder()
                .city("BUSAN")
                .street("SEOGU")
                .zipCode("30921")
                .statusType(StatusType.PREPARING)
                .build();

        //given
        OrderDTO orderDTO = OrderDTO.builder()
                .orderDate(LocalDateTime.now())
                .deliveryDTO(deliveryDTO)
                .orderItemDTOSet(new HashSet<>())
                .build();

    }
}
