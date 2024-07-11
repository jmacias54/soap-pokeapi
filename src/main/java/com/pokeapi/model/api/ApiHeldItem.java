package com.pokeapi.model.api;

public class ApiHeldItem {
	private ApiItem item;

	public ApiItem getItem() {
		return item;
	}

	public void setItem(ApiItem item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "ApiHeldItem{" +
			"item=" + item +
			'}';
	}
}
