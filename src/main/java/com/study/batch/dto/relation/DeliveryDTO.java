package com.study.batch.dto.relation;

import com.study.batch.dto.relation.type.StatusType;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@EqualsAndHashCode
@NoArgsConstructor(force = true)
@SequenceGenerator(
        name = "DELIVERY_SEQ_GENERATOR",
        schema = "`PSS`",
        sequenceName = "`DELIVERY_SEQ`",
        initialValue = 1, allocationSize = 5)
@Table(name = "`DELIVERY`", schema = "`PSS`")
public class DeliveryDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DELIVERY_SEQ_GENERATOR")
    @Column(name = "`DELIVERY_ID`")
    private final long id;
    @Column(name = "`CITY`")
    private final String city;
    @Column(name = "`STREET`")
    private final String street;
    @Column(name = "`ZIP_CODE`")
    private final String zipCode;
    @Enumerated(EnumType.STRING)
    @Column(name = "`DELIVERY_STATUS`")
    private StatusType statusType;

    // 양방향 매핑
    @OneToOne(mappedBy = "deliveryDTO", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "`ORDER_ID`")
    private OrderDTO orderDTO;

    @Builder
    public DeliveryDTO(long id, String city, String street, String zipCode, StatusType statusType, OrderDTO orderDTO) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
        this.statusType = statusType;
    }
}
