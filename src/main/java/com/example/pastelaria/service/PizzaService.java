package com.example.pastelaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.pastelaria.model.ResponseModel;
import com.example.pastelaria.model.Pizza;
import com.example.pastelaria.repository.PizzaRepository;
import jakarta.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class PizzaService {
   

    @Autowired
    private PizzaRepository P;
    private ResponseModel RM;
     

    @PostConstruct
    public void init() {
        List<Pizza> pizzas = List.of(
            new Pizza("Pizza de Calabresa", "Pizza com calabresa e cebola", 25.00),
            new Pizza("Pizza de Mussarela", "Pizza de mussarela com molho de tomate", 20.00),
            new Pizza("Pizza de Frango com Catupiry", "Pizza com frango desfiado e catupiry", 28.00),
            new Pizza("Pizza Portuguesa", "Pizza com presunto, ovos, cebola e azeitona", 30.00),
            new Pizza("Pizza Vegetariana", "Pizza com vegetais frescos", 26.00),
            new Pizza("Pizza de Marguerita", "Pizza com tomate, mussarela e manjericão", 27.00),
            new Pizza("Pizza de Milho", "Pizza com milho e catupiry", 24.00),
            new Pizza("Pizza de Brócolis", "Pizza com brócolis e molho especial", 23.00),
            new Pizza("Pizza de Doce de Leite", "Pizza com doce de leite e cobertura de açúcar", 22.00)
        );

        P.saveAll(pizzas);
    }


   

    //list all products
    public List<Pizza> getAllPasteis(){
        return P.findAll();
    }

    public ResponseEntity<?> getPastelById(Long id) {
        Optional<Pizza> optionalPastel = P.findById(id);
        if (optionalPastel.isPresent()) {
            return new ResponseEntity<Pizza>(optionalPastel.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<ResponseModel>(HttpStatus.NOT_FOUND);
        }
    }
  
    public ResponseEntity<Pizza> cadastrar(Pizza pastel) {
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

        Pizza savedPastel = P.save(pastel);
        return new ResponseEntity<>(savedPastel, HttpStatus.CREATED);
    }


    public ResponseEntity<?> Alterar(Pizza p){

        if(p.getNome().equals("")){
            RM.setMessage("Nome é obrigatorio");
            return new ResponseEntity<ResponseModel>(RM, HttpStatus.BAD_REQUEST);
        }
        else if(p.getPreco()==0){
            RM.setMessage("preco");
            return new ResponseEntity<ResponseModel>(RM, HttpStatus.BAD_REQUEST);
        }else{
            RM.setMessage("FOI CADASTRADO");
            return new  ResponseEntity<Pizza>(P.save(p),HttpStatus.OK);      
        }
        
    }

 
    public ResponseEntity<ResponseModel> remover (long codigo){
       P.deleteById(codigo);

       RM.setMessage("produto removido");
       return new  ResponseEntity<ResponseModel>(RM,HttpStatus.OK);      

    }

}