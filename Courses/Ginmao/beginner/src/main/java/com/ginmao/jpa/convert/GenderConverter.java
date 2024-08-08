package com.ginmao.jpa.convert;

import com.ginmao.domain.Gender;

import javax.persistence.Converter;

@Converter
public class GenderConverter extends EncodableAttributeConverter<Gender,String>{
    public GenderConverter() {
        super(Gender.class);
    }
}
