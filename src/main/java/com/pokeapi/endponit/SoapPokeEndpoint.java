package com.pokeapi.endponit;


import com.pokeapi.gen.*;
import com.pokeapi.service.PokeServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class SoapPokeEndpoint {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());


	@Autowired
	private PokeServices pokeService;

	private static final String NAMESPACE_URI = "http://pokeapi.com/gen";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPokemonDetailsRequest")
	@ResponsePayload
	public ResponsePokemonDetails getPokemonDetails(@RequestPayload GetPokemonDetailsRequest request) {
		ResponsePokemonDetails response = new ResponsePokemonDetails();

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAbilitiesRequest")
	@ResponsePayload
	public ResponseAbilities getAbilities(@RequestPayload GetAbilitiesRequest request) {
		logger.debug(" --- getAbilities --- ");
		logger.debug(" --- GetAbilitiesRequest : "+request);

		return pokeService.getAbilities(request.getPokemonName());

	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBaseExperienceRequest")
	@ResponsePayload
	public ResponseBaseExperience getBaseExperience(@RequestPayload GetBaseExperienceRequest request) {

		return pokeService.getBaseExperience(request.getPokemonName());
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getHeldItemsRequest")
	@ResponsePayload
	public ResponseHeldItems getHeldItems(@RequestPayload GetHeldItemsRequest request) {
		return pokeService.getHeldItems(request.getPokemonName());
	}


	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getIdRequest")
	@ResponsePayload
	public ResponseId getId(@RequestPayload GetIdRequest request) {
		return pokeService.getId(request.getPokemonName());

	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getNameRequest")
	@ResponsePayload
	public ResponseName getName(@RequestPayload GetNameRequest request) {
		return pokeService.getName(request.getPokemonName());

	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getLocationAreaEncountersRequest")
	@ResponsePayload
	public ResponseLocationAreaEncounters getLocationAreaEncounters(@RequestPayload GetLocationAreaEncountersRequest request) {
		return pokeService.getLocationAreaEncounters(request.getPokemonName());
	}


}
