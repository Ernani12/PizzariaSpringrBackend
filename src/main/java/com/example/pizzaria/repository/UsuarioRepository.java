package com.example.pizzaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pizzaria.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);

}
