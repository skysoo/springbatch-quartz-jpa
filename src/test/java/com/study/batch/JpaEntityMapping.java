package com.study.batch;

import com.study.batch.dao.service.*;
import com.study.batch.dto.*;
import com.study.batch.dto.type.RoleType;
import com.study.batch.dto.type.StatusType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class JpaEntityMapping {
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
        orderDTO.setMemberDTO(memberDTO);

        //given
        ItemDTO itemDTO = ItemDTO.builder()
                .name("MACBOOK")
                .price(3190000)
                .stockQuantity(2)
                .orderItemDTOSet(new HashSet<>())
                .build();

        //given
        OrderItemDTO orderItemDTO = OrderItemDTO.builder()
                .orderPrice(itemDTO.getPrice())
                .count(1)
                .build();
        orderItemDTO.setItemDTO(itemDTO);
        orderItemDTO.setOrderDTO(orderDTO);

        //when
        orderItemService.save(orderItemDTO);

        //then
        MemberDTO memberDTO1 = orderDTO.getMemberDTO();
        assertThat(memberDTO1).isNotNull();
        assertThat(memberDTO1.getOrderDTOSet()).isNotNull();
    }

    @Test
    void searchTest(){
        Optional<MemberDTO> byId = memberService.findById(7l);

//        //when
        Optional.ofNullable(byId)
        .ifPresent(name-> System.out.println("Member Name : " + name));

    }
}
