package com.pokeapi.config;

import com.pokeapi.service.LogbookService;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.server.endpoint.MethodEndpoint;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Component
public class IpAddressInterceptor implements EndpointInterceptor {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private LogbookService logbookService;

	@Override
	public boolean handleRequest(MessageContext messageContext, Object endpoint) throws Exception {
		if (endpoint instanceof MethodEndpoint) {
			MethodEndpoint methodEndpoint = (MethodEndpoint) endpoint;
			String methodName = methodEndpoint.getMethod().getName();
			String className = methodEndpoint.getMethod().getDeclaringClass().getSimpleName();

			logger.debug("Request made to method: " + className + "." + methodName);
			LocalDateTime requestTime = LocalDateTime.now();
			String formattedRequestTime = requestTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

			String ipAddress = request.getRemoteAddr();
			logger.debug("Client IP Address: " + ipAddress);
			this.logbookService.save(methodName,ipAddress,formattedRequestTime);
		}



		return true;
	}

	@Override
	public boolean handleResponse(MessageContext messageContext, Object endpoint) throws Exception {
		return true;
	}

	@Override
	public boolean handleFault(MessageContext messageContext, Object endpoint) throws Exception {
		return true;
	}

	@Override
	public void afterCompletion(MessageContext messageContext, Object endpoint, Exception ex) throws Exception {
		// Optional: You can add cleanup code here
	}
}
