package com.study.batch.dto.sub;

import com.study.batch.dto.ItemDTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@EqualsAndHashCode
public class Book extends ItemDTO {
    @Column(name = "`AUTHOR`")
    private String author;
    @Column(name = "`ISBN`")
    private String isbn;
}
