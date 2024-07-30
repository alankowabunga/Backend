package com.pure_springboot.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

/*
    可能錯誤原因
*   1. 缺少構造函數：如果你希望每個枚舉常量有一個特定的值（如數字），則需要提供私有構造函數來設置這些值。
    2. 缺少成員變量：需要一個成員變量來儲存每個枚舉值的數值。
    3. 缺少方法：如果需要根據數值獲取枚舉實例，則需要添加相應的方法。
* */
@AllArgsConstructor
public enum Gender{
    MALE("0"),
    FEMALE("1");

    @Getter
    private String value;

//    private Gender(String value){
//        this.value = value;
//    }

//    public String getValue(){
//        return this.value;
//    }
}
