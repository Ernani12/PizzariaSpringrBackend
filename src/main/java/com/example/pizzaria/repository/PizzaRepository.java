package com.example.pizzaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pizzaria.model.Pizza;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {

}
