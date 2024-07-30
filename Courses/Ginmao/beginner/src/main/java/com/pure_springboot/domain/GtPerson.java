package com.pure_springboot.domain;

import com.pure_springboot.jpa.convert.GenderConverter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class GtPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    private String name;

    private LocalDate birthday;

    @Convert(converter = GenderConverter.class)
    private Gender gender;

}
