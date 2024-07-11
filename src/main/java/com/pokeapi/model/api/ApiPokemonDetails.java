package com.pokeapi.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ApiPokemonDetails {

	private List<ApiAbility> abilities;
	@JsonProperty("base_experience")
	private int baseExperience;
	@JsonProperty("held_items")
	private List<ApiHeldItem> heldItems;
	private int id;
	private String name;
	@JsonProperty("location_area_encounters")
	private String locationAreaEncounters;

}
