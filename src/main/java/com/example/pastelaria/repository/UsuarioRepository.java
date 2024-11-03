package com.example.pastelaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pastelaria.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);

}
