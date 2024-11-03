package com.example.pizzaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.pizzaria.model.Administrador;
import com.example.pizzaria.model.ResponseModel;
import com.example.pizzaria.repository.AdministradorRepository;
 

public class AdministradorService {
    

    @Autowired
    private AdministradorRepository A;

    private ResponseModel RM;

    //list all 
    public List<Administrador> getAdms(){
        return A.findAll();

    }

    public ResponseEntity<?> cadastrar(Administrador a){

        if(a.getEmail().equals("")){
            RM.setMessage("Email é obrigatorio");
            return new ResponseEntity<ResponseModel>(RM, HttpStatus.BAD_REQUEST);
        }
        else if(a.getSenha().equals("")){
            RM.setMessage("senha vazia");
            return new ResponseEntity<ResponseModel>(RM, HttpStatus.BAD_REQUEST);
        }else{
            return new  ResponseEntity<Administrador>(A.save(a),HttpStatus.CREATED);
        }
    }


    public ResponseEntity<?> Alterar(Administrador a){

        if(a.getEmail().equals("")){
            RM.setMessage("Email é obrigatorio");
            return new ResponseEntity<ResponseModel>(RM, HttpStatus.BAD_REQUEST);
        }
        else if(a.getSenha().equals("")){
            RM.setMessage("senha vazia");
            return new ResponseEntity<ResponseModel>(RM, HttpStatus.BAD_REQUEST);
        }else{
            RM.setMessage("FOI CADASTRADO");
            return new  ResponseEntity<Administrador>(A.save(a),HttpStatus.OK);      
        }
        
    }


    public ResponseEntity<ResponseModel> remover (long codigo){
       A.deleteById(codigo);

       RM.setMessage("produto removido");
       return new  ResponseEntity<ResponseModel>(RM,HttpStatus.OK);      

    }
}
