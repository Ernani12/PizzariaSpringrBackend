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
import com.example.pizzaria.model.Usuario;
import com.example.pizzaria.service.UsuarioService;

@RestController
public class UsuarioController {

    UsuarioService U;

    @GetMapping("/getusuarios")
    public List<Usuario> getPasteis() {
        return U.getPasteis();
    }

    @PostMapping("/cadastrarusuario")
    public ResponseEntity<?> cadastrar(@RequestBody Usuario u) {
        return U.cadastrar(u);
    }
    
    @PutMapping("/alterarusuario")
    public ResponseEntity<?> alterar(@RequestBody Usuario u) {
        return U.Alterar(u);
    }

    @DeleteMapping("/removerusuario/{pastelId}")
    public void removerPastel(@PathVariable Long usuarioid) {
        U.remover(usuarioid);
    }
}
