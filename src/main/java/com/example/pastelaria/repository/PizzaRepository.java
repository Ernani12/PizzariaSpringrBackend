package com.example.pastelaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pastelaria.model.Pizza;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {

}
