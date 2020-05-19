package com.qa.controller;

import com.qa.Controller.DeckController;
import com.qa.Domain.Deck;
import com.qa.dto.DeckDTO;
import com.qa.service.DeckService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DeckControllerUnitTest {

    @InjectMocks
    private DeckController deckController;

    @Mock
    private DeckService service;

    private List<Deck> decks;

    private Deck testDeck;

    private Deck testDeckWithId;

    private long deckId = 1L;

    private DeckDTO deckDTO;

    private final ModelMapper mapper = new ModelMapper();

    private DeckDTO mapToDTO(Deck deck){
        return this.mapper.map(deck, DeckDTO.class);
    }

    @Before
    public void setUp(){
        this.decks = new ArrayList<>();
        this.testDeck = new Deck("Test deckName");
        this.decks.add(testDeck);
        this.testDeckWithId = new Deck(testDeck.getDeckName());
        this.testDeckWithId.setDeckId(this.deckId);
        this.deckDTO = this.mapToDTO(testDeckWithId);
    }

    @Test
    public void getAllDeckTest(){
        when(service.readDeck()).thenReturn(this.decks.stream().map(this::mapToDTO).collect(Collectors.toList()));
        assertFalse("No decks found", this.deckController.getAllDecks().getBody().isEmpty());
        verify(service, times(1)).readDeck();
    }

    @Test
    public void createDeckTest(){
        when(this.service.createDeck(testDeck)).thenReturn(this.deckDTO);
        assertEquals(this.deckController.createDeck(testDeck), new ResponseEntity<DeckDTO>(this.deckDTO, HttpStatus.CREATED));
        verify(this.service, times(1)).createDeck(testDeck);
    }

    @Test
    public void deleteDeckTestFalse(){
        this.deckController.deleteDeck(deckId);
        verify(service, times(1)).deleteDeck(deckId);
    }


    @Test
    public void deleteCardTestTrue(){
        when(service.deleteDeck(3L)).thenReturn(true);
        this.deckController.deleteDeck(3L);
        verify(service, times(1)).deleteDeck(3L);
    }

    @Test
    public void getCardByIDTest(){
        when(this.service.findDeckById(deckId)).thenReturn(this.deckDTO);
        assertEquals(this.deckController.getDeckById(deckId), new ResponseEntity<DeckDTO>(this.deckDTO, HttpStatus.OK));
        verify(service, times(1)).findDeckById(deckId);
    }

}
