package com.example.pizzaria.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.pizzaria.model.Pizza;
import com.example.pizzaria.service.PizzaService;

@RestController
@CrossOrigin
public class PizzaController {

    PizzaService S;
  

    @GetMapping("/")
    public String API(){
        return "Pizzaria";
    }

    public PizzaController(PizzaService pastelService) {
        this.S = pastelService;
    }

    @GetMapping("/getpizzas")
    public List<Pizza> getAllPizzas() {
        return S.getAllPizzas();
    }

    @PostMapping("/cadastrarpastel")
    public ResponseEntity<?> cadastrar(@RequestBody Pizza p) {
        return S.cadastrar(p);
    }
     
    @PutMapping("/alterarpastel")
    public ResponseEntity<?> alterar(@RequestBody Pizza p) {
        return S.Alterar(p);
    }

    @DeleteMapping("/removerpastel/{pastelId}")
    public void removerPastel(@PathVariable Long pastelId) {
        S.remover(pastelId);
    }
}
