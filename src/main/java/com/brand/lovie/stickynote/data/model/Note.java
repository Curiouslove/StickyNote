package com.brand.lovie.stickynote.data.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    @Column(length = 2000)
    private String content;

}
