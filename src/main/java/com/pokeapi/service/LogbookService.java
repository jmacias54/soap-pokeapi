package com.pokeapi.service;

import com.pokeapi.entity.Logbook;
import com.pokeapi.repository.LogbookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

@Service
public class LogbookService {

	@Autowired
	private LogbookRepository logbookRepository;


	private static final Logger LOGGER = Logger.getLogger(LogbookService.class.getName());

	public Integer save(
		String method,
		String ip,
		String dateRequest,
		String request,
		String response,
		Long millis) {

		Logbook logbook = new Logbook();
		logbook.setMethod(method);
		logbook.setIpAddress(ip);
		logbook.setRequest(request);
		logbook.setResponse(response);
		logbook.setDuration(millis);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		LocalDateTime dateTime = LocalDateTime.parse(dateRequest, formatter);
		logbook.setDateRequest(dateTime);
		LOGGER.info("SQL Date: " + dateTime);
		Logbook savedLogbook = logbookRepository.save(logbook);

		return savedLogbook.getId();
	}

}
