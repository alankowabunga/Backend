package com.alanproject.spring_framework_practice.BusinuessCalculation.Service;


import com.alanproject.spring_framework_practice.BusinuessCalculation.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;

//@Component
@Service
public class BusinessCalculationService {

    DataService dataService;

    //constructor injection
    @Autowired
    public BusinessCalculationService(@Qualifier("Mongo") DataService dataService){
        this.dataService = dataService;
    }
    public int getMax(){
        int[] data = dataService.getData();
        return Arrays.stream(data).max().orElse(0);
    }
}
