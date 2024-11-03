package com.example.pastelaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pastelaria.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}

