package com.pure_springboot.jpa.convert;

import com.pure_springboot.domain.Gender;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class GenderConverter implements AttributeConverter<Gender,String> {

    @Override
    public String convertToDatabaseColumn(Gender gender) {
        return gender == null?null: gender.getValue();
    }

    @Override
    public Gender convertToEntityAttribute(String dbData) {
        return dbData == null? null:Gender.valueOf(dbData);
    }
}
