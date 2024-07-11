package com.pokeapi.repository;

import com.pokeapi.entity.Logbook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogbookRepository extends JpaRepository<Logbook, Integer> {
}
