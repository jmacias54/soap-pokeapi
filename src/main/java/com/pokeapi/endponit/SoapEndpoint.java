package com.pokeapi.endponit;


import com.pokeapi.gen.GetExampleRequest;
import com.pokeapi.gen.GetExampleResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class SoapEndpoint {

	private static final String NAMESPACE_URI = "http://pokeapi.com/gen";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getExampleRequest")
	@ResponsePayload
	public GetExampleResponse handleExampleRequest(@RequestPayload GetExampleRequest request) {
		GetExampleResponse response = new GetExampleResponse();
		response.setOutput("Hello, " + request.getInput() + "!");

		return response;
	}
}
