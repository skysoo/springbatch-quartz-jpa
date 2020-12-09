package com.study.batch.dto;

import lombok.*;

import javax.persistence.*;
import java.time.format.DateTimeFormatter;

@ToString
@Getter
@NoArgsConstructor
@Entity
@Table(name = "`PAY2`", schema = "`PSS`")
public class Pay2 {
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
    public Pay2(Long id, Long amount, String txName, String txDateTime) {
        this.id = id;
        this.amount = amount;
        this.txName = txName;
        this.txDateTime = txDateTime;
    }
}
