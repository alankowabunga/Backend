package com.alanproject.spring_framework_practice.BusinuessCalculation.Service;

import com.alanproject.spring_framework_practice.BusinuessCalculation.DataService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository
@Qualifier("Mongo")
public class MongoDbDataService implements DataService {

    @Override
    public int[] getData() {
        return new int[]{4,5,6};
    }
}
