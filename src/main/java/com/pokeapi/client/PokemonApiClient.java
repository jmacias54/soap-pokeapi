package com.pokeapi.client;

import com.pokeapi.model.api.ApiPokemonDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Component
public class PokemonApiClient{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private RestTemplate restTemplate;

	@Value("${pokeapi.base-url}")
	private String pokeApiBaseUrl;

	public ApiPokemonDetails getPokemonInfo(String pokemonName) {
		logger.debug(" ::: getPokemonInfo ::: ");
		String url = pokeApiBaseUrl + pokemonName;
		ApiPokemonDetails response = restTemplate.getForObject(url, ApiPokemonDetails.class);
		logger.debug(" ::: response "+response);

		return response;
	}
}