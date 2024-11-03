package com.example.pastelaria.model;


import jakarta.persistence.*;
import jakarta.transaction.Transactional;

@Entity
@Transactional
@Table(name = "Administrador")
public class Administrador extends Pessoa {
    
    private String nome;
   
    // getters and setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Enumerated(EnumType.STRING)
    private Role role;


}