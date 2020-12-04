package com.study.batch.dto;

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
        name = "CATEGORY_SEQ_GENERATOR",
        schema = "`PSS`",
        sequenceName = "`CATEGORY_SEQ`",
        initialValue = 1, allocationSize = 5)
@Table(name = "`CATEGORY`", schema = "`PSS`")
public class CategoryDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGORY_SEQ_GENERATOR")
    @Column(name = "`CATEGORY_ID`")
    private final long id;
    @Column(name = "`NAME`")
    private final String name;

    /**
     * 카테고리 셀프 매핑
     **/
    @ManyToOne
    @JoinColumn(name = "`PARENT_ID`")
    private CategoryDTO parent;

    @OneToMany(mappedBy = "parent")
    private Set<CategoryDTO> child = new HashSet<>();

    /**
     * Item 이랑 다대다 관계 설정 -실전에서는 사용하지 마라
     **/
//    @ManyToMany
//    @JoinTable(name = "`CATEGORY_ITEM`",schema = "`PSS`",
//    joinColumns = @JoinColumn(name = "`CATEGORY_ID`"),
//    inverseJoinColumns = @JoinColumn(name = "`ITEM_ID`"))
//    private Set<ItemDTO> itemDTOSet  = new HashSet<>();
    @OneToMany(mappedBy = "categorys")
    private Set<CategoryItemDTO> itemDTOSet = new HashSet<>();

    @Builder
    public CategoryDTO(long id, String name, CategoryDTO parent, Set<CategoryDTO> child) {
        this.id = id;
        this.name = name;
        this.parent = parent;
        this.child = child;
    }

}
