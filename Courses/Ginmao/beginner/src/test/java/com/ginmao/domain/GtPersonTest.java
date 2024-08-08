package com.ginmao.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GtPersonTest {

    @Test
    void testGtPerson() {

        GtPerson gtPerson = GtPerson.builder()
            .name("Alan")
            .birthday(LocalDate.of(1997,2,18))
            .address("南區")
            .gender(Gender.MALE)
            .idno("X123456789")
            .build();

        assertEquals(gtPerson.getIdno(),"X123456789");
    }
}
