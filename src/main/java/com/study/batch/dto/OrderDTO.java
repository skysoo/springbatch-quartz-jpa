package com.study.batch.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@EqualsAndHashCode
@NoArgsConstructor(force = true)
@SequenceGenerator(
        name = "ORDER_SEQ_GENERATOR",
        schema = "`PSS`",
        sequenceName = "`ORDER_SEQ`",
        initialValue = 1, allocationSize = 5)
@Table(name = "`ORDERS`", schema = "`PSS`")
public class OrderDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER_SEQ_GENERATOR")
    @Column(name = "`ORDER_ID`")
    private final long id;
//    @Temporal(TemporalType.TIMESTAMP) // 타입이 Date 일 경우
    @Column(name = "`ORDER_DATE`")
    private final LocalDateTime orderDate;

    // 연관 관계 주인이 되야 한다. - mappedBy 속성도 없음
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "`MEMBER_ID`")
    private MemberDTO memberDTO;

    // 양방향 매핑
    @OneToMany(mappedBy = "orderDTO", fetch = FetchType.LAZY)
    private Set<OrderItemDTO> orderItemDTOSet = new HashSet<>();

    // 연관 관계 주인
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "`DELIVERY_ID`")
    private DeliveryDTO deliveryDTO;

    // 연관 관계 편의 메서드
    public void setMemberDTO(MemberDTO memberDTO){
        this.memberDTO = memberDTO;
        memberDTO.getOrderDTOSet().add(this);
    }

    @Builder
    public OrderDTO(long id, LocalDateTime orderDate, MemberDTO memberDTO, Set<OrderItemDTO> orderItemDTOSet, DeliveryDTO deliveryDTO) {
        this.id = id;
        this.orderDate = orderDate;
        this.memberDTO = memberDTO;
        this.orderItemDTOSet = orderItemDTOSet;
        this.deliveryDTO = deliveryDTO;
    }
}
