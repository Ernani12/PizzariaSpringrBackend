package com.example.pastelaria.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pastelaria.model.Pessoa;


public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    Pessoa findByEmail(String email);

} 
