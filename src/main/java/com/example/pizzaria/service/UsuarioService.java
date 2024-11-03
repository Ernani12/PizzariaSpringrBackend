package com.example.pizzaria.service;

import java.util.List;
  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.pizzaria.model.ResponseModel;
import com.example.pizzaria.model.Usuario;
import com.example.pizzaria.repository.UsuarioRepository;

public class UsuarioService {
    
    @Autowired
    private UsuarioRepository U;

    private ResponseModel RM;

    public List<Usuario> getAllPasteis() {
        return U.findAll();
    }

    //list all products
    public List<Usuario> getPasteis(){
        return U.findAll();
 
   }

    public ResponseEntity<?> cadastrar(Usuario u){

        if(u.getEmail().equals("")){
            RM.setMessage("email é obrigatorio");
            return new ResponseEntity<ResponseModel>(RM, HttpStatus.BAD_REQUEST);
        }
        else if(u.getSenha().equals("")){
            RM.setMessage("senha vazia");
            return new ResponseEntity<ResponseModel>(RM, HttpStatus.BAD_REQUEST);
        }else{
            return new  ResponseEntity<Usuario>(U.save(u),HttpStatus.CREATED);
        }
    }


    public ResponseEntity<?> Alterar(Usuario u){

        if(u.getEmail().equals("")){
            RM.setMessage("Email é obrigatorio");
            return new ResponseEntity<ResponseModel>(RM, HttpStatus.BAD_REQUEST);
        }
        else if(u.getSenha().equals("")){
            RM.setMessage("senha vazia");
            return new ResponseEntity<ResponseModel>(RM, HttpStatus.BAD_REQUEST);
        }else{
            RM.setMessage("FOI CADASTRADO");
            return new  ResponseEntity<Usuario>(U.save(u),HttpStatus.OK);      
        }
        
    }


    public ResponseEntity<ResponseModel> remover (long codigo){
       U.deleteById(codigo);

       RM.setMessage("produto removido");
       return new  ResponseEntity<ResponseModel>(RM,HttpStatus.OK);      

    }
}