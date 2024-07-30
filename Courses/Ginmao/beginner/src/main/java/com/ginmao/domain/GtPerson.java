package com.ginmao.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
public class GtPerson{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

}
