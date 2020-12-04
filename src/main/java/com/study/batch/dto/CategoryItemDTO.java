package com.study.batch.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * ITEM - CATEGORY 간의 다대다 관계를 일대다 - 다대일 관계로 풀기위해 중간 테이블을 엔티티로 승격!
 **/
@Entity
@Getter
@EqualsAndHashCode
@NoArgsConstructor(force = true)
@SequenceGenerator(
        name = "CATEGORY_ITEM_SEQ_GENERATOR",
        schema = "`PSS`",
        sequenceName = "`CATEGORY_ITEM_SEQ`",
        initialValue = 1, allocationSize = 5)
@Table(name = "`CATEGORY_ITEM`", schema = "`PSS`")
public class CategoryItemDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGORY_ITEM_SEQ_GENERATOR")
    @Column(name = "`CATEGORY_ITEM_ID`")
    private final Long id;

    @ManyToOne
    @JoinColumn(name = "`ITEM_ID`")
    private ItemDTO items;

    @ManyToOne
    @JoinColumn(name = "`CATEGORY_ID`")
    private CategoryDTO categorys;
}
