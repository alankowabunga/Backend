package com.ginmao.provider;

import com.ginmao.domain.GtDistrict;
import com.ginmao.domain.GtDistrictType;

import java.util.ArrayList;
import java.util.List;

public class CityProvider {

    public static List<GtDistrict> list() {
        List<GtDistrict> cities = new ArrayList<>();
        cities.add(generateCity("63000000", "臺北市"));
        cities.add(generateCity("64000000", "高雄市"));
        cities.add(generateCity("65000000", "新北市"));
        cities.add(generateCity("66000000", "臺中市"));
        cities.add(generateCity("67000000", "臺南市"));
        cities.add(generateCity("68000000", "桃園市"));
        cities.add(generateCity("10002000", "宜蘭縣"));
        cities.add(generateCity("10004000", "新竹縣"));
        cities.add(generateCity("10005000", "苗栗縣"));
        cities.add(generateCity("10007000", "彰化縣"));
        cities.add(generateCity("10008000", "南投縣"));
        cities.add(generateCity("10009000", "雲林縣"));
        cities.add(generateCity("10010000", "嘉義縣"));
        cities.add(generateCity("10013000", "屏東縣"));
        cities.add(generateCity("10014000", "臺東縣"));
        cities.add(generateCity("10015000", "花蓮縣"));
        cities.add(generateCity("10017000", "基隆市"));
        cities.add(generateCity("10018000", "新竹市"));
        cities.add(generateCity("10020000", "嘉義市"));
        cities.add(generateCity("10016000", "澎湖縣"));
        cities.add(generateCity("09007000", "連江縣"));
        cities.add(generateCity("09020000", "金門縣"));
        return cities;
    }

    private static GtDistrict generateCity(String no, String name) {
        GtDistrict city = new GtDistrict();
        city.setCode(no);
        city.setName(name);
        city.setType(GtDistrictType.CITY);
        return city;
    }
}
