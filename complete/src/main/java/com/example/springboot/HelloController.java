package com.example.springboot;

import com.example.city.City;
import com.example.city.ReadCityList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@GetMapping("/cities/{id}")
	public City cities (@PathVariable Integer id) {
		ReadCityList cityReader = new ReadCityList();

		cityReader.readFile();
		return cityReader.getCities().get(id - 1); // Correction factor to ensure that id aligns with positions
	}
}
