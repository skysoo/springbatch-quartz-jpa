package com.study.batch.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.format.DateTimeFormatter;

@ToString
@Getter
@NoArgsConstructor
@Entity
@Table(name = "`PAY`", schema = "`PSS`")
public class Pay {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long amount;
    @Column(name = "tx_name")
    private String txName;
    @Column(name = "tx_date_time")
    private String txDateTime;

    @Builder
    public Pay(Long id, Long amount, String txName, String txDateTime) {
        this.id = id;
        this.amount = amount;
        this.txName = txName;
        this.txDateTime = txDateTime;
    }
}
