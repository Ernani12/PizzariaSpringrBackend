package com.example.pizzaria.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;


@Entity
@Transactional
@Data
@AllArgsConstructor
@Table(name = "Pizza")
public class Pizza { 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String descricao;
    private Double preco;


    @ManyToMany(mappedBy = "pasteis")
    private List<Pedido> pedidos;
    // getters and setters

    public Pizza() {
    }


    public Pizza(String nome, String descricao, Double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public Pizza(String nome, String descricao, Double preco, List<Pedido> pedidos) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.pedidos = pedidos;
    }

    
}