package com.study.batch.dto.sub;

import com.study.batch.dto.ItemDTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@EqualsAndHashCode
public class Album extends ItemDTO {
    @Column(name = "`ARTIST`")
    private String artist;
    @Column(name = "`ETC`")
    private String etc;
}
