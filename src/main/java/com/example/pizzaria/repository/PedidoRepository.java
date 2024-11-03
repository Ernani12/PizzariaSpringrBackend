package com.example.pizzaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pizzaria.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}

