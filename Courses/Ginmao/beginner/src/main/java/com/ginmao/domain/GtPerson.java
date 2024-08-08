package com.ginmao.domain;

import com.ginmao.jpa.convert.GenderConverter;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "gt_person")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder // for unit test
public class GtPerson extends BaseEntity{

    @NonNull
    @Column(name = "name_")
    private String name;

    @NonNull
    @Column(name = "birthday_")
    private LocalDate birthday;

    @NonNull
    @Column(name = "gender_" , length = 1)
    @Convert(converter = GenderConverter.class)
    private Gender gender;

    @NonNull
    @Column(name = "idno_" , length = 10)
    private String idno;

    @Column(name = "address_")
    private String address;


}


