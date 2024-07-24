package com.pokeapi.test.endpoint;

import com.pokeapi.endponit.SoapPokeEndpoint;
import com.pokeapi.gen.*;
import com.pokeapi.service.PokeServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SoapPokeEndpointTest {

	@InjectMocks
	private SoapPokeEndpoint soapPokeEndpoint;

	@Mock
	private PokeServices pokeServices;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}


	void testGetPokemonDetails() {
		GetPokemonDetailsRequest request = new GetPokemonDetailsRequest();
		request.setPokemonName("pikachu");

		PokemonDetails pokemonDetails = new PokemonDetails();
		pokemonDetails.setId(123);
		pokemonDetails.setName("pikachu");

		ResponsePokemonDetails expectedResponse = new ResponsePokemonDetails();
		expectedResponse.setPokemonDetails(pokemonDetails);

		verify(pokeServices).getPokemonDetails("pikachu");
		when(pokeServices.getPokemonDetails("pikachu")).thenReturn(expectedResponse);

		ResponsePokemonDetails actualResponse = soapPokeEndpoint.getPokemonDetails(request);


		assertNotNull(actualResponse);
	}

	@Test
	void testGetAbilities() {
		GetAbilitiesRequest request = new GetAbilitiesRequest();
		request.setPokemonName("pikachu");

		ResponseAbilities expectedResponse = new ResponseAbilities();

		when(pokeServices.getAbilities("pikachu")).thenReturn(expectedResponse);

		ResponseAbilities actualResponse = soapPokeEndpoint.getAbilities(request);

		assertNotNull(actualResponse);
		assertEquals(expectedResponse, actualResponse);
	}

	@Test
	void testGetBaseExperience() {
		GetBaseExperienceRequest request = new GetBaseExperienceRequest();
		request.setPokemonName("pikachu");

		ResponseBaseExperience expectedResponse = new ResponseBaseExperience();

		when(pokeServices.getBaseExperience("pikachu")).thenReturn(expectedResponse);

		ResponseBaseExperience actualResponse = soapPokeEndpoint.getBaseExperience(request);

		assertNotNull(actualResponse);
		assertEquals(expectedResponse, actualResponse);
	}

	@Test
	void testGetHeldItems() {
		GetHeldItemsRequest request = new GetHeldItemsRequest();
		request.setPokemonName("pikachu");

		ResponseHeldItems expectedResponse = new ResponseHeldItems();

		when(pokeServices.getHeldItems("pikachu")).thenReturn(expectedResponse);

		ResponseHeldItems actualResponse = soapPokeEndpoint.getHeldItems(request);

		assertNotNull(actualResponse);
		assertEquals(expectedResponse, actualResponse);
	}

	@Test
	void testGetId() {
		GetIdRequest request = new GetIdRequest();
		request.setPokemonName("pikachu");

		ResponseId expectedResponse = new ResponseId();

		when(pokeServices.getId("pikachu")).thenReturn(expectedResponse);

		ResponseId actualResponse = soapPokeEndpoint.getId(request);

		assertNotNull(actualResponse);
		assertEquals(expectedResponse, actualResponse);
	}

	@Test
	void testGetName() {
		GetNameRequest request = new GetNameRequest();
		request.setPokemonName("pikachu");

		ResponseName expectedResponse = new ResponseName();

		when(pokeServices.getName("pikachu")).thenReturn(expectedResponse);

		ResponseName actualResponse = soapPokeEndpoint.getName(request);

		assertNotNull(actualResponse);
		assertEquals(expectedResponse, actualResponse);
	}

	@Test
	void testGetLocationAreaEncounters() {
		GetLocationAreaEncountersRequest request = new GetLocationAreaEncountersRequest();
		request.setPokemonName("pikachu");

		ResponseLocationAreaEncounters expectedResponse = new ResponseLocationAreaEncounters();

		when(pokeServices.getLocationAreaEncounters("pikachu")).thenReturn(expectedResponse);

		ResponseLocationAreaEncounters actualResponse = soapPokeEndpoint.getLocationAreaEncounters(request);

		assertNotNull(actualResponse);
		assertEquals(expectedResponse, actualResponse);
	}
}