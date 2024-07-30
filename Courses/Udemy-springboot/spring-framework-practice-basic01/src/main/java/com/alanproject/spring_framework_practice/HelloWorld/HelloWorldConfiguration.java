package com.alanproject.spring_framework_practice.HelloWorld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/* java 16 引入的 record class: 可自動建立 class 伴隨的 contructor、getter、setter、toString、equal 等冗長程式
* */
record  Person(String name , int age , Address address){};
record Address(String county,String city){};
@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name(){
        return "@ My name is Alan.";
    }

    @Bean
    public int age(){
        return 27;
    }

    @Bean
    public Person person(){
        Person person = new Person("Alan",27 , address());
        return person;
    }

    @Bean(name = "methodCallPerson")
    public Person person2(){
        return personPara(name(),age() , address());
    }

    @Bean Person personPara(String name, int age, Address address){
        return new Person(name ,age , address);
    }

    @Bean(name = "address1")
    public Address address(){
        Address address = new Address("South District","Taichung");
        return address;
    }
    @Bean(name = "address2")
    public Address address2(){
        Address address = new Address("Wuwei","Yulin");
        return address;
    }

}
