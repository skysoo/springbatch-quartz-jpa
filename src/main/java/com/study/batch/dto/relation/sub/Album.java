package com.study.batch.dto.relation.sub;

import com.study.batch.dto.relation.ItemDTO;
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
