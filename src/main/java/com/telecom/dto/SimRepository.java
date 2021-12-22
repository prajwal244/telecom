package com.telecom.dto;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telecom.model.Sim;

public interface SimRepository extends JpaRepository<Sim, Long> {

}
