package com.alanproject.spring_framework_practice.BusinuessCalculation;

import com.alanproject.spring_framework_practice.BusinuessCalculation.Service.BusinessCalculationService;
import com.alanproject.spring_framework_practice.BusinuessCalculation.Service.MySqlDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan("com.alanproject.spring_framework_practice.BusinuessCalculation.Service")
public class AppBusinessCalculation {
    public static void main(String[] args) {

        /* pojo
        MySqlDataService mySqlDataService = new MySqlDataService();
        * */

        /* Spring Context
        * */
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppBusinessCalculation.class);) {

            int ans = context.getBean(BusinessCalculationService.class).getMax();
            System.out.println("@ ans :"+ans);
        }
    }
}
