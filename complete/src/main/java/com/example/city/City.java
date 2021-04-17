package com.example.city;

public class City {
    int city_id;
    String city_name;
    String city_province;

    public City (int city_id, String city_name, String city_province) {
        this.city_id = city_id;
        this.city_name = city_name;
        this.city_province = city_province;
    }

    public int getCityId() {
        return city_id;
    }

    public String getCityName() {
        return city_name;
    }

    public String getCityProvince() {
        return city_province;
    }
}