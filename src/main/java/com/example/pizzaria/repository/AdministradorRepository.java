package com.example.pizzaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pizzaria.model.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {

    Administrador findByEmail(String email);

}
