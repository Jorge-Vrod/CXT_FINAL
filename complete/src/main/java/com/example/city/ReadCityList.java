package com.example.city;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReadCityList {
    List<City> cities;

    public void readFile(String path) {
        this.cities = new ArrayList<City>();

        if (path == null) {
            path = "./data/CList.csv";
        }

        try {
            File inputF = new File(path);
            InputStream inputFS = new FileInputStream(inputF);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));

            this.cities = br.lines().skip(1).map(mapToItem).collect(Collectors.toList());

            br.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readFile() {
        this.readFile(null);
    }


    private final Function<String, City> mapToItem = (line) -> {

        String[] city_line = line.split(","); // Break csv by commas

        return new City(Integer.parseInt(city_line[0]),city_line[1],city_line[2]);
    };
}