package com.pokeapi.service;

import com.pokeapi.client.PokemonApiClient;
import com.pokeapi.gen.*;
import com.pokeapi.mapper.PokemonMapper;
import com.pokeapi.model.api.ApiPokemonDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.nonNull;


@Service
public class PokeServices {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());


	@Autowired
	private PokemonApiClient pokemonApiClient;

	@Autowired
	private PokemonMapper pokemonMapper;


	public ResponsePokemonDetails getPokemonDetails(String name) {
		ResponsePokemonDetails response = new ResponsePokemonDetails();

		ApiPokemonDetails details = this.pokemonApiClient.getPokemonInfo(name);

		if(nonNull(details)){

		}
		return response;
	}


	public ResponseAbilities getAbilities(String name) {
		logger.debug(" --- getAbilities --- ");
		logger.debug(" --- name: "+name);

		ResponseAbilities response = new ResponseAbilities();
		ApiPokemonDetails details = this.pokemonApiClient.getPokemonInfo(name);

		if(nonNull(details)){
			List<Ability> list = pokemonMapper.mapApiAbilitiesToAbilities(details.getAbilities());
			AbilitiesList abilitiesList = new AbilitiesList();
			abilitiesList.getAbility().addAll(list);
			response.setAbilities(abilitiesList);
		}
		return response;
	}


	public ResponseBaseExperience getBaseExperience(String name) {
		logger.debug(" --- getBaseExperience --- ");
		logger.debug(" --- name: "+name);

		ResponseBaseExperience response = new ResponseBaseExperience();
		ApiPokemonDetails details = this.pokemonApiClient.getPokemonInfo(name);

		if(nonNull(details)){
			response.setBaseExperience(details.getBaseExperience());
		}
		return response;
	}

	public ResponseHeldItems getHeldItems(String name) {
		logger.debug(" --- getHeldItems --- ");
		logger.debug(" --- name: "+name);

		ResponseHeldItems response = new ResponseHeldItems();
		ApiPokemonDetails details = this.pokemonApiClient.getPokemonInfo(name);

		if(nonNull(details)){
			List<HeldItem> list = pokemonMapper.mapApiHeldItemsToHeldItems(details.getHeldItems());
			HeldItemsList heldItemsList = new HeldItemsList();
			heldItemsList.getHeldItem().addAll(list);
			response.setHeldItems(heldItemsList);
		}
		return response;
	}


	public ResponseId getId(String name) {
		logger.debug(" --- ResponseId --- ");
		logger.debug(" --- name: "+name);
		ResponseId response = new ResponseId();
		ApiPokemonDetails details = this.pokemonApiClient.getPokemonInfo(name);

		if(nonNull(details)){
			response.setId(details.getId());
		}
		return response;
	}

	public ResponseName getName(String name) {
		logger.debug(" --- ResponseId --- ");
		logger.debug(" --- name: "+name);
		ResponseName response = new ResponseName();
		ApiPokemonDetails details = this.pokemonApiClient.getPokemonInfo(name);

		if(nonNull(details)){
			response.setName(details.getName());
		}
		return response;
	}

	public ResponseLocationAreaEncounters getLocationAreaEncounters(String name) {
		logger.debug(" --- getLocationAreaEncounters --- ");
		logger.debug(" --- name: "+name);
		ResponseLocationAreaEncounters response = new ResponseLocationAreaEncounters();
		ApiPokemonDetails details = this.pokemonApiClient.getPokemonInfo(name);

		if(nonNull(details)){
			response.setLocationAreaEncounters(details.getLocationAreaEncounters());
		}
		return response;
	}
}
