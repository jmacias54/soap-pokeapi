package com.pokeapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Date;

@Entity
@Data
public class Logbook {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String ipAddress;
    private String method;
    private Date dateRequest;
}
