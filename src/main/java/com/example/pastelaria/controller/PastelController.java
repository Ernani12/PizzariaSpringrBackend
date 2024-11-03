package com.example.pastelaria.controller;

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
import com.example.pastelaria.model.Pastel;
import com.example.pastelaria.service.PastelService;

@RestController
@CrossOrigin
public class PastelController {

    PastelService S;
  

    @GetMapping("/")
    public String API(){
        return "Pastelaria";
    }

    public PastelController(PastelService pastelService) {
        this.S = pastelService;
    }

    @GetMapping("/getpasteis")
    public List<Pastel> getAllPasteis() {
        return S.getAllPasteis();
    }

    @PostMapping("/cadastrarpastel")
    public ResponseEntity<?> cadastrar(@RequestBody Pastel p) {
        return S.cadastrar(p);
    }
     
    @PutMapping("/alterarpastel")
    public ResponseEntity<?> alterar(@RequestBody Pastel p) {
        return S.Alterar(p);
    }

    @DeleteMapping("/removerpastel/{pastelId}")
    public void removerPastel(@PathVariable Long pastelId) {
        S.remover(pastelId);
    }
}
