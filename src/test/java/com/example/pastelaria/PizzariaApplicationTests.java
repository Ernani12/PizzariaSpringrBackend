package com.example.pastelaria;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.pizzaria.model.Pizza;
import com.example.pizzaria.repository.PizzaRepository;
import com.example.pizzaria.service.PizzaService;

@SpringBootTest
class PizzariaApplicationTests {


	@Mock
    private PizzaRepository pizzaRepository;

    @InjectMocks
    private PizzaService pizzaService;

	private Pizza pizza1;
    private Pizza pizza2;
    

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        // Criar dados mockados
        pizza1 = new Pizza();
        pizza1.setId(1L);
        pizza1.setNome("Pizza de Catupiry");
        pizza1.setDescricao("Pìzza com recheio de Catupiry");
        pizza1.setPreco(5.00);

        pizza2 = new Pizza();
        pizza2.setId(2L);
        pizza2.setNome("Frango de Queijo");
        pizza2.setDescricao("Frango com recheio de queijo.");
        pizza2.setPreco(4.50);
    }

    @Test
    public void testGetAllPasteis() {
        // Etapa 1: Configurar o comportamento do mock
        List<Pizza> pizzasMock = Arrays.asList(pizza1, pizza2);
        when(pizzaRepository.findAll()).thenReturn(pizzasMock);

        // Etapa 2: Chamar o método a ser testado
        List<Pizza> pizzas = pizzaService.getAllPizzas();

        // Etapa 3: Verificar o resultado
        assertNotNull(pizzas);
        assertEquals(2, pizzas.size());
        assertEquals("Pizza de Portuguesa", pizzas.get(0).getNome());
        assertEquals("Pizza de Italiana", pizzas.get(1).getNome());

        // Verificar se o método findAll foi chamado uma vez
        verify(pizzaRepository, times(1)).findAll();
    }      


    @Test
    public void testGetPizzaById() {
        // Etapa 1: Configurar o comportamento do mock
        when(pizzaRepository.findById(1L)).thenReturn(Optional.of(pizza1));

        // Etapa 2: Chamar o método a ser testado
        ResponseEntity<?> responseEntity = pizzaService.getPizzaById(1L);

        // Etapa 3: Verificar o resultado
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        // Verificar se o método findById foi chamado com o parâmetro correto
        verify(pizzaRepository, times(1)).findById(1L);

        // Se for um HttpStatus.OK, verificar o corpo da resposta
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            Object responseBody = responseEntity.getBody();
            assertTrue(responseBody instanceof Pizza);
            Pizza pizza = (Pizza) responseBody;
            assertEquals("Pizza de Carne", pizza.getNome());
        }
    }

    @Test
    public void testCreatePizza() {
     // Etapa 1: Configurar o comportamento do mock
     when(pizzaRepository.save(pizza1)).thenReturn(pizza1);

     // Etapa 2: Chamar o método a ser testado
     ResponseEntity<Pizza> responseEntity = pizzaService.cadastrar(pizza1);

     // Etapa 3: Verificar o resultado
     assertNotNull(responseEntity);
     assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());

     // Verificar se o método save foi chamado uma vez
     verify(pizzaRepository, times(1)).save(pizza1);

     // Verificar se o objeto salvo é o correto
     Pizza savedPizza = responseEntity.getBody();
     assertNotNull(savedPizza);
     assertEquals("Pizza de Palmito", savedPizza.getNome());
 
    }
}
