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

@RestController
public class CityController {

	@RequestMapping("/")
	public String index() throws Exception {
		Rollbar rollbar = Rollbar.init(withAccessToken("de4ac55a62664f59bc04d9677cea9b48").build());
		rollbar.log("Hello, Rollbar");
		rollbar.close(true);
		return "Greetings from Spring Boot!";
	}
	@GetMapping("/cities")
	public Cities cities() {
		ReadCityList cityReader = new ReadCityList();
		cityReader.readFile();

		return new Cities(cityReader.getCities());
	}

	@GetMapping("/cities/{id}")
	public City cities (@PathVariable Integer id) {
		ReadCityList cityReader = new ReadCityList();

		cityReader.readFile();
		return cityReader.getCities().get(id - 1); // Correction factor to ensure that id aligns with positions
	}

	@GetMapping("/es_cities")
	public Cities es_cities() {
		ReadCityList cityReader = new ReadCityList();
		cityReader.readFile("./src/main/java/com/example/city/data/CESList.csv");

		return new Cities(cityReader.getCities());
	}

	@GetMapping("/es_cities/{id}")
	public City es_cities(@PathVariable Integer id) {
		ReadCityList cityReader = new ReadCityList();

		cityReader.readFile("./src/main/java/com/example/city/data/CESList.csv");
		return cityReader.getCities().get(id - 1); // Correction factor to ensure that id aligns with positions
	}
}
