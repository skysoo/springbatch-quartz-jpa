package com.study.batch.dto.relation;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@EqualsAndHashCode
@NoArgsConstructor(force = true)
@SequenceGenerator(
        name = "ORDER_ITEM_SEQ_GENERATOR",
        schema = "`PSS`",
        sequenceName = "`ORDER_ITEM_SEQ`",
        initialValue = 1, allocationSize = 5)
@Table(name = "`ORDER_ITEM`", schema = "`PSS`")
public class OrderItemDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER_ITEM_SEQ_GENERATOR")
    @Column(name = "`ORDER_ITEM_ID`")
    private final long id;
    @Column(name = "`ORDER_PRICE`")
    private final int orderPrice;
    @Column(name = "`COUNT`")
    private final int count;

    // 연관 관계 주인
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "`ORDER_ID`")
    private OrderDTO orderDTO;

    // 연관 관계 주인
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "`ITEM_ID`")
    private ItemDTO itemDTO;

    // 연관 관계 편의 메서드
    public void setOrderDTO(OrderDTO orderDTO){
        this.orderDTO = orderDTO;
        orderDTO.getOrderItemDTOSet().add(this);
    }

    // 연관 관계 편의 메서드
    public void setItemDTO(ItemDTO itemDTO){
        this.itemDTO = itemDTO;
        itemDTO.getOrderItemDTOSet().add(this);
    }

    @Builder
    public OrderItemDTO(long id, int orderPrice, int count, OrderDTO orderDTO, ItemDTO itemDTO) {
        this.id = id;
        this.orderPrice = orderPrice;
        this.count = count;
        this.orderDTO = orderDTO;
        this.itemDTO = itemDTO;
    }
}
