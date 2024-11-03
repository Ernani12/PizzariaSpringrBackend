package com.example.pastelaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pastelaria.model.Pastel;

public interface PastelRepository extends JpaRepository<Pastel, Long> {

}
