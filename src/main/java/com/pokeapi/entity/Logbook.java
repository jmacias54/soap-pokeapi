package com.pokeapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Data
public class Logbook {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String ipAddress;
    private String method;
    private LocalDateTime dateRequest;
    private String request;
    private String response;
    private Long duration;
}
