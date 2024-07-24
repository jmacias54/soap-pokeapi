package com.pokeapi.test.entity;

import com.pokeapi.entity.Logbook;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.Month;

public class LogbookTest {

	@Test
	void testLogbookSettersAndGetters() {
		Logbook logbook = new Logbook();

		logbook.setId(1);
		logbook.setIpAddress("192.168.1.1");
		logbook.setMethod("GET");
		logbook.setDateRequest(LocalDateTime.of(2024, Month.JULY, 24, 10, 30)); // Usando LocalDateTime
		logbook.setRequest("Request data");
		logbook.setResponse("Response data");
		logbook.setDuration(123L);

		assertEquals(1, logbook.getId());
		assertEquals("192.168.1.1", logbook.getIpAddress());
		assertEquals("GET", logbook.getMethod());
		assertEquals(LocalDateTime.of(2024, Month.JULY, 24, 10, 30), logbook.getDateRequest()); // Comparando con LocalDateTime
		assertEquals("Request data", logbook.getRequest());
		assertEquals("Response data", logbook.getResponse());
		assertEquals(123L, logbook.getDuration());
	}
}
