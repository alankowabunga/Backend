package com.alanproject.spring_framework_practice.BusinuessCalculation.Service;

import com.alanproject.spring_framework_practice.BusinuessCalculation.DataService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository
@Primary
public class MySqlDataService implements DataService {
    @Override
    public int[] getData() {
        return new int[]{0,1,2};
    }
}
