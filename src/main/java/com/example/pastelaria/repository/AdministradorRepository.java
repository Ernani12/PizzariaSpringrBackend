package com.example.pastelaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pastelaria.model.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {

    Administrador findByEmail(String email);

}
