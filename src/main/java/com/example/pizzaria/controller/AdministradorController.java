package com.example.pizzaria.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.pizzaria.model.Administrador;
import com.example.pizzaria.service.AdministradorService;

@RestController
public class AdministradorController {
   
    AdministradorService A;

   
    @GetMapping("/getadms")
    public List<Administrador> getAdm(){
        return  A.getAdms();
    }

    @PostMapping("/cadastraradm")
    public ResponseEntity<?> cadastrar(@RequestBody Administrador a) {
        return A.cadastrar(a);
    }
    
    @PutMapping("/alteraradms")
    public ResponseEntity<?> alterar(@RequestBody Administrador a) {
        return A.Alterar(a);
    }

    @DeleteMapping("/removeradms/{pastelId}")
    public void removerPastel(@PathVariable Long pastelId) {
        A.remover(pastelId);
    }
}
