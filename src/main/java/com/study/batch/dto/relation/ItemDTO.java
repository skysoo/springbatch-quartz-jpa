package com.study.batch.dto.relation;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@EqualsAndHashCode
@NoArgsConstructor(force = true)
@SequenceGenerator(
        name = "ITEM_SEQ_GENERATOR",
        schema = "`PSS`",
        sequenceName = "`ITEM_SEQ`",
        initialValue = 1, allocationSize = 5)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // 테이블간의 상속 전략을 언제든지 바꿀수 있다.
@DiscriminatorColumn
@Table(name = "`ITEM`", schema = "`PSS`")
public class ItemDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ITEM_SEQ_GENERATOR")
    @Column(name = "`ITEM_ID`")
    private final long id;
    @Column(name = "`NAME`")
    private final String name;
    @Column(name = "`PRICE`")
    private final int price;
    @Column(name = "`STOCK_QUANTITY`")
    private final int stockQuantity;

    // 양방향 매핑
    @OneToMany(mappedBy = "itemDTO", fetch = FetchType.LAZY)
    private Set<OrderItemDTO> orderItemDTOSet = new HashSet<>();

    // 양방향 매핑 - 실전에서는 사용하지마라 아래 처럼 일대다 - 다대일로 풀어서 사용
//    @ManyToMany(mappedBy = "itemDTOSet")
//    private Set<CategoryDTO> categoryDTOSet = new HashSet<>();

    @OneToMany(mappedBy = "items")
    private Set<CategoryItemDTO> categoryDTOSet = new HashSet<>();

    @Builder
    public ItemDTO(long id, String name, int price, int stockQuantity, Set<OrderItemDTO> orderItemDTOSet) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.orderItemDTOSet = orderItemDTOSet;
    }
}
