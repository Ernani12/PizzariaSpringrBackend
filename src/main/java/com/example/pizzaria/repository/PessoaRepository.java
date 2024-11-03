package com.example.pizzaria.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pizzaria.model.Pessoa;


public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    Pessoa findByEmail(String email);

} 
