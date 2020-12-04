package com.study.batch.dto;

import com.study.batch.dto.type.RoleType;
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
        name = "`MEMBER_SEQ_GENERATOR`",
        schema = "`PSS`",
        sequenceName = "`MEMBER_SEQ`",
        initialValue = 1, allocationSize = 5)
@Table(name = "`MEMBER`", schema = "`PSS`")
public class MemberDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "`MEMBER_SEQ_GENERATOR`")
    @Column(name = "`MEMBER_ID`")
    private final long id;
    @Column(name = "`NAME`")
    private final String name;
    @Column(name = "`CITY`")
    private final String city;
    @Column(name = "`STREET`")
    private final String street;
    @Column(name = "`ZIP_CODE`")
    private final String zipCode;
    @Enumerated(EnumType.STRING)
    @Column(name = "`ROLE`")
    private final RoleType roleType;

    @OneToMany(mappedBy = "memberDTO", fetch = FetchType.LAZY)
    private Set<OrderDTO> orderDTOSet = new HashSet<>();

    @Builder
    public MemberDTO(long id, String name, String city, String street, String zipCode, RoleType roleType, Set<OrderDTO> orderDTOSet) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
        this.roleType = roleType;
        this.orderDTOSet = orderDTOSet;
    }
}
