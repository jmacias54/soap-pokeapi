package com.pokeapi.test.mapper;

import com.pokeapi.gen.Ability;
import com.pokeapi.gen.HeldItem;
import com.pokeapi.model.api.ApiAbility;
import com.pokeapi.model.api.ApiHeldItem;
import com.pokeapi.mapper.PokemonMapper;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PokemonMapperTest {

	private final PokemonMapper pokemonMapper = new PokemonMapper();

	@Test
	void testMapApiAbilitiesToAbilities() {
		ApiAbility apiAbility1 = new ApiAbility();
		ApiAbility apiAbility2 = new ApiAbility();

		List<ApiAbility> apiAbilities = Arrays.asList(apiAbility1, apiAbility2);

		List<Ability> abilities = pokemonMapper.mapApiAbilitiesToAbilities(apiAbilities);

		assertNotNull(abilities);
		assertEquals(apiAbilities.size(), abilities.size());
	}

	@Test
	void testMapApiHeldItemsToHeldItems() {
		ApiHeldItem apiHeldItem1 = new ApiHeldItem();
		ApiHeldItem apiHeldItem2 = new ApiHeldItem();
		List<ApiHeldItem> apiHeldItems = Arrays.asList(apiHeldItem1, apiHeldItem2);

		List<HeldItem> heldItems = pokemonMapper.mapApiHeldItemsToHeldItems(apiHeldItems);

		assertNotNull(heldItems);
		assertEquals(apiHeldItems.size(), heldItems.size());
	}

	@Test
	void testMapApiAbilitiesToAbilitiesEmptyList() {
		List<ApiAbility> apiAbilities = Collections.emptyList();

		List<Ability> abilities = pokemonMapper.mapApiAbilitiesToAbilities(apiAbilities);

		assertNotNull(abilities);
		assertTrue(abilities.isEmpty());
	}

	@Test
	void testMapApiHeldItemsToHeldItemsEmptyList() {
		List<ApiHeldItem> apiHeldItems = Collections.emptyList();

		List<HeldItem> heldItems = pokemonMapper.mapApiHeldItemsToHeldItems(apiHeldItems);

		assertNotNull(heldItems);
		assertTrue(heldItems.isEmpty());
	}
}
