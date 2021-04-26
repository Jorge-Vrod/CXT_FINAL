package com.example.springboot;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
@SpringBootTest
@AutoConfigureMockMvc
public class CityControllerTest {

	@Autowired
	private MockMvc mvc;


	@Test
	public void getHello() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("Greetings from Spring Boot!")));
	}

	@Test
	public void getEscities() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/es_cities").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json("{\"cities\":[\"Barcelona\",\"Madrid\",\"Sevilla\",\"Valencia\",\"Zaragoza\",\"Malaga\",\"Palma\",\"Murcia\",\"Las Palmas\",\"A Coruna\",\"Donostia\",\"Bilbao\",\"Alicante\",\"Cordoba\",\"Valladolid\",\"Vigo\",\"Gijon\",\"Vitoria-Gasteiz\",\"Granada\",\"Badalona\",\"Cartagena\",\"Sabadell\",\"Jerez de la Frontera\",\"Santa Cruz\",\"Pamplona\",\"Almeria\",\"Oviedo\",\"Mataro\",\"Albacete\",\"Santander\",\"Castellon de la Plana\",\"Burgos\",\"La Laguna\",\"Badajoz\",\"Salamanca\",\"Logrono\",\"Huelva\",\"Marbella\",\"Ciudad de Melilla\",\"Tarragona\",\"Leon\",\"Cadiz\",\"Jaen\",\"Algeciras\",\"Ourense\",\"Girona\",\"Lugo\",\"Caceres\",\"Lorca\",\"Santiago de Compostela\",\"El Puerto de Santa Maria\",\"Ciudad de Ceuta\",\"Pontevedra\",\"Mijas\",\"Guadalajara\",\"Aviles\",\"Rubi\",\"Toledo\",\"Gandia\",\"Benidorm\",\"Benalmadena\",\"Villanueva y Geltru\",\"Ferrol\",\"La Linea de la Concepcion\",\"Arrecife\",\"Zamora\",\"Granollers\",\"Linares\",\"Merida\",\"Motril\",\"avila\",\"Torrelavega\",\"Villareal\",\"Ibiza\",\"Portugalete\",\"Antequera\",\"Plasencia\",\"ecija\",\"Tudela\",\"Onteniente\",\"Burriana\",\"Villena\",\"Ronda\",\"Castro-Urdiales\",\"Arcos de la Frontera\",\"Puerto de la Cruz\",\"Mahon\",\"eibar\",\"Villanueva de la Serena\",\"Jumilla\",\"Villarrobledo\",\"Almonte\",\"Laguna de Duero\",\"Torre del Mar\",\"Moguer\",\"Palafrugell\",\"Loja\",\"Requena\",\"Guadix\",\"Navalmoral de la Mata\",\"Ejea de los Caballeros\",\"Azpeitia\",\"Noya\",\"Cuevas del Almanzora\",\"Socuellamos\",\"Olivenza\",\"Palos de la Frontera\",\"Santona\",\"Tafalla\",\"La Baneza\",\"Canteras\",\"Miajadas\",\"Piedras Blancas\",\"Puigcerda\",\"Valldoreix\",\"Corella\",\"Cintruenigo\",\"Talayuela\",\"Porto Cristo\",\"Moraleja\",\"San Adrian\",\"Arroyo de la Luz\",\"Valencia de Alcantara\",\"Mutriku\",\"La Herradura\",\"Garachico\",\"Lodosa\",\"Malpartida de Plasencia\",\"Hornachuelos\",\"Viana\",\"Hervas\",\"Olite\",\"Villargordo\",\"Cascante\",\"Azagra\",\"Luarca\",\"Ribaforada\",\"Mendavia\",\"Viella\",\"San Francisco Javier\",\"Milagro\",\"Oza de los Rios\",\"Cortes\",\"Estartit\",\"Leiza\",\"Marcilla\",\"Villafranca\",\"Puente la Reina\",\"Jarandilla de la Vera\",\"Ribadesella\",\"Caparroso\",\"Vegadeo\",\"Losar de la Vera\",\"Alcuescar\",\"Madronera\",\"Carcastillo\",\"Fustinana\",\"Echarri-Aranaz\",\"Ablitas\",\"Funes\",\"Valtierra\",\"Valverde del Fresno\",\"Palencia\",\"Lleida\",\"Segovia\",\"Huesca\",\"Ciudad Real\",\"Soria\",\"Teruel\",\"Cuenca\"]}"));
	}

}
