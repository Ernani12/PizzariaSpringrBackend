package com.example.pastelaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.pastelaria.model.ResponseModel;
import com.example.pastelaria.model.Pastel;
import com.example.pastelaria.repository.PastelRepository;
import jakarta.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class PastelService {
   

    @Autowired
    private PastelRepository P;
    private ResponseModel RM;
     

    @PostConstruct
    public void init() {
        List<Pastel> pasteis = List.of(
            new Pastel("Pastel de Carne", "Pastel recheado com carne moída temperada", 5.00),
            new Pastel("Pastel de Queijo", "Pastel recheado com queijo mussarela derretido", 4.50),
            new Pastel("Pastel de Palmito", "Pastel Palmito", 5.50),
            new Pastel("Pastel de Queijo/presunto", "Pastel recheado com queijo, presunto", 6.00),
            new Pastel("Pastel de Vegetariano", "vegetariano", 6.50),
            new Pastel("Pastel de Tomate", "Pastel recheado tomate", 5.75),
            new Pastel("Pastel de Milho", "Pastel milhocatupiry", 7.00),
            new Pastel("Pastel de Brocolis", "Pastel recheado brocolis", 4.75),
            new Pastel("Pastel de Doce de Leite", "Pastel recheado com doce de leite", 4.50)
        );

        P.saveAll(pasteis);
    }

   

    //list all products
    public List<Pastel> getAllPasteis(){
        return P.findAll();
    }

    public ResponseEntity<?> getPastelById(Long id) {
        Optional<Pastel> optionalPastel = P.findById(id);
        if (optionalPastel.isPresent()) {
            return new ResponseEntity<Pastel>(optionalPastel.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<ResponseModel>(HttpStatus.NOT_FOUND);
        }
    }
  
    public ResponseEntity<Pastel> cadastrar(Pastel pastel) {
        if (pastel == null) {
            RM.setMessage("O pastel recebido é nulo");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (pastel.getNome() == null || pastel.getNome().isEmpty()) {
            RM.setMessage("Nome é obrigatório");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (pastel.getPreco() == null || pastel.getPreco() == 0) {
            RM.setMessage("Preço não pode ser 0");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Pastel savedPastel = P.save(pastel);
        return new ResponseEntity<>(savedPastel, HttpStatus.CREATED);
    }


    public ResponseEntity<?> Alterar(Pastel p){

        if(p.getNome().equals("")){
            RM.setMessage("Nome é obrigatorio");
            return new ResponseEntity<ResponseModel>(RM, HttpStatus.BAD_REQUEST);
        }
        else if(p.getPreco()==0){
            RM.setMessage("preco");
            return new ResponseEntity<ResponseModel>(RM, HttpStatus.BAD_REQUEST);
        }else{
            RM.setMessage("FOI CADASTRADO");
            return new  ResponseEntity<Pastel>(P.save(p),HttpStatus.OK);      
        }
        
    }

 
    public ResponseEntity<ResponseModel> remover (long codigo){
       P.deleteById(codigo);

       RM.setMessage("produto removido");
       return new  ResponseEntity<ResponseModel>(RM,HttpStatus.OK);      

    }

}