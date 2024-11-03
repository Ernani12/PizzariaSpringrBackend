package com.example.pizzaria.model;

import java.util.List;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;

@Entity
@Transactional
@Table(name = "Usuario")
public class Usuario extends Pessoa {
   
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Enumerated(EnumType.STRING)
    private Role role = Role.ROLE_USER;

    @OneToMany(mappedBy = "usuario")
    private List<Pedido> pedidos;
    // getters and setters
}