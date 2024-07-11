package com.pokeapi.model.api;

public class ApiAbility {

	private ApiAbilityDetails ability;

	public ApiAbilityDetails getAbility() {
		return ability;
	}

	public void setAbility(ApiAbilityDetails ability) {
		this.ability = ability;
	}

	@Override
	public String toString() {
		return "ApiAbility{" +
			"ability=" + ability +
			'}';
	}
}
