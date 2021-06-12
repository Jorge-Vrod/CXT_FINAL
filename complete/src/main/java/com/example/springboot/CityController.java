package com.example.springboot;

import com.example.city.Cities;
import com.example.city.City;
import com.example.city.ReadCityList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import static com.rollbar.notifier.config.ConfigBuilder.withAccessToken;
import com.rollbar.notifier.Rollbar;
import com.example.springboot.RollbarToken;


import java.util.EmptyStackException;

@RestController
public class CityController {

	@RequestMapping("/")
	public String index() throws Exception {
		RollbarToken.getInstance().log("/");
		return "Greetings from Spring Boot!";
	}

	@GetMapping("/cities")
	public Cities cities() {
		try {
			ReadCityList cityReader = new ReadCityList();
			cityReader.readFile();
			//throw new EmptyStackException();
			return new Cities(cityReader.getCities());
		} catch (Exception e) {
			RollbarToken.getInstance().log("/cities: " + e.toString());
			return null;
		}

	}

	@GetMapping("/cities/{id}")
	public City cities (@PathVariable Integer id) {
		try {
			ReadCityList cityReader = new ReadCityList();
			cityReader.readFile();
			return cityReader.getCities().get(id - 1); // Correction factor to ensure that id aligns with positions
		} catch (Exception e) {
			RollbarToken.getInstance().log("/cities/" + id + ": " + e.toString());
			return null;
		}
	}

	@GetMapping("/es_cities")
	public Cities es_cities() {
		try {
			ReadCityList cityReader = new ReadCityList();
			cityReader.readFile("./src/main/java/com/example/city/data/CESList.csv");
			return new Cities(cityReader.getCities());
		} catch (Exception e) {
			RollbarToken.getInstance().log("/es_cities: " + e.toString());
			return null;
		}
	}

	@GetMapping("/es_cities/{id}")
	public City es_cities(@PathVariable Integer id) {
		try {
			ReadCityList cityReader = new ReadCityList();
			cityReader.readFile("./src/main/java/com/example/city/data/CESList.csv");
			return cityReader.getCities().get(id - 1); // Correction factor to ensure that id aligns with positions
		} catch (Exception e) {
			RollbarToken.getInstance().log("/es_cities/" + id + ": " + e.toString());
			return null;
		}
	}
}
