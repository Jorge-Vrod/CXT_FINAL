package com.example.city;

import java.util.List;

public class Cities {
    private String[] cities;

    public Cities(List<City> cities) {
        String[] list = new String[cities.size()];
        for (int i = 0; i <= cities.size()-1; i++) {
            list[i] =  cities.get(i).getCityName();
        }
        this.cities = list;
    }

    public String[] getCities() {
        return this.cities;
    }

}
