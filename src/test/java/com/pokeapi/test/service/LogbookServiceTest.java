package com.pokeapi.test.service;

import com.pokeapi.entity.Logbook;
import com.pokeapi.repository.LogbookRepository;
import com.pokeapi.service.LogbookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class LogbookServiceTest {

	@Mock
	private LogbookRepository logbookRepository;

	@InjectMocks
	private LogbookService logbookService;

	@Test
	void testSaveLogbook() {
		String method = "GET";
		String ip = "192.168.1.1";
		String dateRequest = LocalDateTime.of(2024, Month.JULY, 24, 10, 30)
			.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		String request = "Request data";
		String response = "Response data";
		Long millis = 123L;

		Logbook logbook = new Logbook();
		logbook.setId(1);
		logbook.setIpAddress(ip);
		logbook.setMethod(method);
		logbook.setDateRequest(LocalDateTime.parse(dateRequest, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		logbook.setRequest(request);
		logbook.setResponse(response);
		logbook.setDuration(millis);

		when(logbookRepository.save(any(Logbook.class))).thenReturn(logbook);

		Integer savedId = logbookService.save(method, ip, dateRequest, request, response, millis);

		assertNotNull(savedId);
		assertEquals(1, savedId);
	}
}
