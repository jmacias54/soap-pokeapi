package com.pokeapi.mapper;

import com.pokeapi.gen.Ability;
import com.pokeapi.gen.HeldItem;
import com.pokeapi.model.api.ApiAbility;
import com.pokeapi.model.api.ApiHeldItem;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PokemonMapper {

	private static ModelMapper modelMapper = new ModelMapper();

	public List<Ability> mapApiAbilitiesToAbilities(List<ApiAbility> apiAbilities) {
		return apiAbilities.stream()
			.map(this::mapApiAbilityToAbility)
			.collect(Collectors.toList());
	}

	private Ability mapApiAbilityToAbility(ApiAbility apiAbility) {
		return modelMapper.map(apiAbility, Ability.class);
	}

	public List<HeldItem> mapApiHeldItemsToHeldItems(List<ApiHeldItem> apiHeldItems) {
		return apiHeldItems.stream()
			.map(this::mapApiHeldItemToHeldItem)
			.collect(Collectors.toList());
	}

	private HeldItem mapApiHeldItemToHeldItem(ApiHeldItem apiHeldItem) {
		return modelMapper.map(apiHeldItem, HeldItem.class);
	}
}
