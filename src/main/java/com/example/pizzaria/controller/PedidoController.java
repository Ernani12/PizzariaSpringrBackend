package com.example.pizzaria.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.pizzaria.model.Pedido;
import com.example.pizzaria.service.PedidoService;
 
public class PedidoController {
    
    PedidoService P;


    @GetMapping("/getpedido")
    public List<Pedido> getPasteis() {
        return P.getPasteis();
    }

    @PostMapping("/cadastrarpedido")
    public ResponseEntity<?> cadastrar(@RequestBody Pedido p) {
        return P.cadastrar(p);
    }
    
    @PutMapping("/alterarpedido")
    public ResponseEntity<?> alterar(@RequestBody Pedido p) {
        return P.Alterar(p);
    }

    @DeleteMapping("/removerpedido/{pastelId}")
    public void removerPastel(@PathVariable Long pedidooid) {
        P.remover(pedidooid);
    }
}
