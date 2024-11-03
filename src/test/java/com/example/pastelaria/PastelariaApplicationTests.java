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

import com.example.pastelaria.model.Pastel;
import com.example.pastelaria.repository.PastelRepository;
import com.example.pastelaria.service.PastelService;

@SpringBootTest
class PastelariaApplicationTests {


	@Mock
    private PastelRepository pastelRepository;

    @InjectMocks
    private PastelService pastelService;

	private Pastel pastel1;
    private Pastel pastel2;
    

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        // Criar dados mockados
        pastel1 = new Pastel();
        pastel1.setId(1L);
        pastel1.setNome("Pastel de Carne");
        pastel1.setDescricao("Pastel com recheio de carne moída.");
        pastel1.setPreco(5.00);

        pastel2 = new Pastel();
        pastel2.setId(2L);
        pastel2.setNome("Pastel de Queijo");
        pastel2.setDescricao("Pastel com recheio de queijo.");
        pastel2.setPreco(4.50);
    }

    @Test
    public void testGetAllPasteis() {
        // Etapa 1: Configurar o comportamento do mock
        List<Pastel> pasteisMock = Arrays.asList(pastel1, pastel2);
        when(pastelRepository.findAll()).thenReturn(pasteisMock);

        // Etapa 2: Chamar o método a ser testado
        List<Pastel> pasteis = pastelService.getAllPasteis();

        // Etapa 3: Verificar o resultado
        assertNotNull(pasteis);
        assertEquals(2, pasteis.size());
        assertEquals("Pastel de Carne", pasteis.get(0).getNome());
        assertEquals("Pastel de Queijo", pasteis.get(1).getNome());

        // Verificar se o método findAll foi chamado uma vez
        verify(pastelRepository, times(1)).findAll();
    }      


    @Test
    public void testGetPastelById() {
        // Etapa 1: Configurar o comportamento do mock
        when(pastelRepository.findById(1L)).thenReturn(Optional.of(pastel1));

        // Etapa 2: Chamar o método a ser testado
        ResponseEntity<?> responseEntity = pastelService.getPastelById(1L);

        // Etapa 3: Verificar o resultado
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        // Verificar se o método findById foi chamado com o parâmetro correto
        verify(pastelRepository, times(1)).findById(1L);

        // Se for um HttpStatus.OK, verificar o corpo da resposta
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            Object responseBody = responseEntity.getBody();
            assertTrue(responseBody instanceof Pastel);
            Pastel pastel = (Pastel) responseBody;
            assertEquals("Pastel de Carne", pastel.getNome());
        }
    }

    @Test
    public void testCreatePastel() {
     // Etapa 1: Configurar o comportamento do mock
     when(pastelRepository.save(pastel1)).thenReturn(pastel1);

     // Etapa 2: Chamar o método a ser testado
     ResponseEntity<Pastel> responseEntity = pastelService.cadastrar(pastel1);

     // Etapa 3: Verificar o resultado
     assertNotNull(responseEntity);
     assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());

     // Verificar se o método save foi chamado uma vez
     verify(pastelRepository, times(1)).save(pastel1);

     // Verificar se o objeto salvo é o correto
     Pastel savedPastel = responseEntity.getBody();
     assertNotNull(savedPastel);
     assertEquals("Pastel de Carne", savedPastel.getNome());
 
    }
}
