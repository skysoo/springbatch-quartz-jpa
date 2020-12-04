package com.study.batch.dto.sub;

import com.study.batch.dto.ItemDTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@EqualsAndHashCode
public class Movie extends ItemDTO {
    @Column(name = "`DIRECTOR`")
    private String director;
    @Column(name = "`ACTOR`")
    private String actor;
}
