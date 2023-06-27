package com.alanLearning;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController //會使控制器 class 的所有方法都會回傳 JSON 格式的回應 response
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    //    record 用來定義純數據 Class
    record Person(String name,int age,double iq){}
    record GreetResponse(
            String greet, //key
            List<String> languageLearned, //key
            Person person //key

    ) {}

    @GetMapping("/greet")
    public GreetResponse greet() { // 定義了一個名為 greet() 的方法，其返回類型為 GreetResponse。
        GreetResponse response = new GreetResponse(
            "hello",  // value
                List.of("Java","Python","JavaScript"),  // value
                new Person("Alan",26,118)  // value
        );
        return response;
    }
//    API
//    public String greet() {
//        return "Hello!";
//    }

}
