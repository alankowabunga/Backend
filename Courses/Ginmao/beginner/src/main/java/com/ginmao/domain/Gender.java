package com.ginmao.domain;

import com.ginmao.util.Encodable;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Gender implements Encodable<String> {

    MALE("1"),
    FEMALE("2");

    @NonNull
    private final String value;

    @Override
    public String getCode() {
        return this.value;
    }
}
