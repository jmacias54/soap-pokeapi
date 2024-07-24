package com.pokeapi.endponit;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokeapi.service.LogbookService;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.server.endpoint.MethodEndpoint;

import java.io.ByteArrayOutputStream;
import java.io.StringWriter;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Aspect
@Component
public class LoggingAspect {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private HttpServletRequest httpServletRequest;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private LogbookService logbookService;



	@Around("execution(* com.pokeapi.endponit..*(..))")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		String methodName = joinPoint.getSignature().toShortString();
		String ipAddress = httpServletRequest.getRemoteAddr();
		LocalDateTime requestTime = LocalDateTime.now();
		String formattedRequestTime = requestTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		String dataIn = "";
		String response;

		logger.info("Request to method: {}", methodName);
		logger.info("Request URL: {}", httpServletRequest.getRequestURL().toString());
		logger.info("Client IP: {}", ipAddress);

		Object[] args = joinPoint.getArgs();

		if (args.length > 0 ) {
			dataIn = objectMapper.writeValueAsString(args[0]);
			logger.info("SOAP Request Payload: {}", dataIn);
		}

		Object result;
		LocalDateTime startTime = LocalDateTime.now();
		try {
			result = joinPoint.proceed();
			 response = objectMapper.writeValueAsString(result);

			logger.info("Response from method: {}: {}", methodName, response);
		} catch (Throwable throwable) {
			logger.error("Exception in method: {}: {}", methodName, throwable.getMessage());
			throw throwable;
		}

		LocalDateTime endTime = LocalDateTime.now();
		Duration duration = Duration.between(startTime, endTime);
		Long millis = duration.toMillis();

		logger.info("Execution time for method {}: {} milliseconds", methodName, duration.toMillis());


		this.logbookService.save(methodName,ipAddress,formattedRequestTime,dataIn,response,millis);
		return result;
	}


	@Before("execution(* com.pokeapi.endponit..*(..))")
	public void logBefore(JoinPoint joinPoint) {
		logger.info("Entrando al método: " + joinPoint.getSignature().getName());
	}

	@AfterReturning(pointcut = "execution(* com.pokeapi.endponit..*(..))", returning = "result")
	public void logAfterReturning(JoinPoint joinPoint, Object result) {
		logger.info("Método: " + joinPoint.getSignature().getName() + " completado. Resultado: " + result);


	}

	@AfterThrowing(pointcut = "execution(* com.pokeapi.endponit..*(..))", throwing = "error")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
		logger.error("Método: " + joinPoint.getSignature().getName() + " arrojó una excepción", error);
	}
}
