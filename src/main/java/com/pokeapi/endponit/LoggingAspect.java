package com.pokeapi.endponit;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

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
