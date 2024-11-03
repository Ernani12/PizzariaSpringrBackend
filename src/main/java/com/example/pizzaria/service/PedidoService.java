package com.example.pizzaria.service;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.pizzaria.model.Pedido;
import com.example.pizzaria.model.ResponseModel;
import com.example.pizzaria.repository.PedidoRepository;

public class PedidoService {
    
    @Autowired
    private PedidoRepository P;

    private ResponseModel RM;

    public List<Pedido> getAllPasteis() {
        return P.findAll();
    }

    //list all products
    public List<Pedido> getPasteis(){
        return P.findAll();
 
   }

    public ResponseEntity<?> cadastrar(Pedido p){

        if(p.getId()==null){
            RM.setMessage("id pedido");
            return new ResponseEntity<ResponseModel>(RM, HttpStatus.BAD_REQUEST);
        }
        else if(p.getData()==null){
            RM.setMessage("data nula");
            return new ResponseEntity<ResponseModel>(RM, HttpStatus.BAD_REQUEST);
        }else{
            return new  ResponseEntity<Pedido>(P.save(p),HttpStatus.CREATED);
        }
    }


    public ResponseEntity<?> Alterar(Pedido p){

        if(p.getId()==null){
            RM.setMessage("id pedido");
            return new ResponseEntity<ResponseModel>(RM, HttpStatus.BAD_REQUEST);
        }
        else if(p.getData()==null){
            RM.setMessage("data nula");
            return new ResponseEntity<ResponseModel>(RM, HttpStatus.BAD_REQUEST);
        }else{
            RM.setMessage("FOI CADASTRADO");
            return new  ResponseEntity<Pedido>(P.save(p),HttpStatus.OK);      
        }
        
    }


    public ResponseEntity<ResponseModel> remover (long codigo){
       P.deleteById(codigo);

       RM.setMessage("produto removido");
       return new  ResponseEntity<ResponseModel>(RM,HttpStatus.OK);      

    }
}