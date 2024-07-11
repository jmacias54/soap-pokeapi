package com.pokeapi.service;

import com.pokeapi.entity.Logbook;
import com.pokeapi.repository.LogbookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;

@Service
public class LogbookService {

	@Autowired
	private LogbookRepository logbookRepository;


	private static final Logger LOGGER = Logger.getLogger(LogbookService.class.getName());

	public Integer save(String method, String ip, String dateRequest) {
		Logbook logbook = new Logbook();
		logbook.setMethod(method);
		logbook.setIpAddress(ip);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		try {
			java.util.Date utilDate = dateFormat.parse(dateRequest);
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			logbook.setDateRequest(sqlDate);
			System.out.println("SQL Date: " + sqlDate);
		} catch (ParseException e) {
			LOGGER.severe("Error parsing date: " + e.getMessage());
		}
		Logbook savedLogbook = logbookRepository.save(logbook);

		return savedLogbook.getId();
	}

}
