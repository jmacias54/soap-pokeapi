package com.pokeapi.test.service;


import com.pokeapi.client.PokemonApiClient;
import com.pokeapi.gen.*;
import com.pokeapi.mapper.PokemonMapper;
import com.pokeapi.model.api.ApiPokemonDetails;
import com.pokeapi.service.PokeServices;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PokeServicesTest {

	@Mock
	private PokemonApiClient pokemonApiClient;

	@Mock
	private PokemonMapper pokemonMapper;

	@InjectMocks
	private PokeServices pokeServices;

	@Test
	void testGetPokemonDetails() {
		String name = "pikachu";
		ApiPokemonDetails apiPokemonDetails = new ApiPokemonDetails();
		when(pokemonApiClient.getPokemonInfo(name)).thenReturn(apiPokemonDetails);
		ResponsePokemonDetails response = pokeServices.getPokemonDetails(name);
		assertNotNull(response);
	}

	@Test
	void testGetAbilities() {
		String name = "pikachu";
		ApiPokemonDetails apiPokemonDetails = new ApiPokemonDetails();
		apiPokemonDetails.setAbilities(Collections.emptyList());
		when(pokemonApiClient.getPokemonInfo(name)).thenReturn(apiPokemonDetails);
		when(pokemonMapper.mapApiAbilitiesToAbilities(any())).thenReturn(Collections.emptyList());

		ResponseAbilities response = pokeServices.getAbilities(name);

		assertNotNull(response);
		assertNotNull(response.getAbilities());
		assertTrue(response.getAbilities().getAbility().isEmpty());
	}

	@Test
	void testGetBaseExperience() {
		String name = "pikachu";
		ApiPokemonDetails apiPokemonDetails = new ApiPokemonDetails();
		apiPokemonDetails.setBaseExperience(50);
		when(pokemonApiClient.getPokemonInfo(name)).thenReturn(apiPokemonDetails);

		ResponseBaseExperience response = pokeServices.getBaseExperience(name);

		assertNotNull(response);
		assertEquals(50, response.getBaseExperience());
	}

	@Test
	void testGetHeldItems() {
		String name = "pikachu";
		ApiPokemonDetails apiPokemonDetails = new ApiPokemonDetails();
		apiPokemonDetails.setHeldItems(Collections.emptyList());
		when(pokemonApiClient.getPokemonInfo(name)).thenReturn(apiPokemonDetails);
		when(pokemonMapper.mapApiHeldItemsToHeldItems(any())).thenReturn(Collections.emptyList());

		ResponseHeldItems response = pokeServices.getHeldItems(name);

		assertNotNull(response);
		assertNotNull(response.getHeldItems());
		assertTrue(response.getHeldItems().getHeldItem().isEmpty());
	}

	@Test
	void testGetId() {
		String name = "pikachu";
		ApiPokemonDetails apiPokemonDetails = new ApiPokemonDetails();
		apiPokemonDetails.setId(25);
		when(pokemonApiClient.getPokemonInfo(name)).thenReturn(apiPokemonDetails);

		ResponseId response = pokeServices.getId(name);

		assertNotNull(response);
		assertEquals(25, response.getId());
	}

	@Test
	void testGetName() {
		String name = "pikachu";
		ApiPokemonDetails apiPokemonDetails = new ApiPokemonDetails();
		apiPokemonDetails.setName(name);
		when(pokemonApiClient.getPokemonInfo(name)).thenReturn(apiPokemonDetails);

		ResponseName response = pokeServices.getName(name);

		assertNotNull(response);
		assertEquals(name, response.getName());
	}

	@Test
	void testGetLocationAreaEncounters() {
		String name = "pikachu";
		ApiPokemonDetails apiPokemonDetails = new ApiPokemonDetails();
		apiPokemonDetails.setLocationAreaEncounters("location data");
		when(pokemonApiClient.getPokemonInfo(name)).thenReturn(apiPokemonDetails);

		ResponseLocationAreaEncounters response = pokeServices.getLocationAreaEncounters(name);

		assertNotNull(response);
		assertEquals("location data", response.getLocationAreaEncounters());
	}
}
