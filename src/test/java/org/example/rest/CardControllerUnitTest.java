package org.example.rest;

import org.example.Controller.CardController;
import org.example.Domain.Card_DB;
import org.example.dto.CardDTO;
import org.example.service.CardService;
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
public class CardControllerUnitTest {

    @InjectMocks
    private CardController cardController;

    @Mock
    private CardService service;

    private List<Card_DB> cards;

    private Card_DB testCard;

    private Card_DB testCardWithId;

    private long cardId = 1L;

    private CardDTO cardDTO;

    private final ModelMapper mapper = new ModelMapper();

    private CardDTO mapToDTO(Card_DB card){
        return this.mapper.map(card, CardDTO.class);
    }

    @Before
    public void setUp(){
        this.cards = new ArrayList<>();
        this.testCard = new Card_DB("Test cardName", "Test cardType");
        this.cards.add(testCard);
        this.testCardWithId = new Card_DB(testCard.getCardName(),testCard.getCardType());
        this.testCardWithId.setCardId(this.cardId);
        this.cardDTO = this.mapToDTO(testCardWithId);
    }

    @Test
    public void getAllCardsTest(){
        when(service.readCards()).thenReturn(this.cards.stream().map(this::mapToDTO).collect(Collectors.toList()));
        assertFalse("No cards found", this.cardController.getAllCards().getBody().isEmpty());
        verify(service, times(1)).readCards();
    }

    @Test
    public void createCardTest(){
        when(this.service.createCard(testCard)).thenReturn(this.cardDTO);
        assertEquals(this.cardController.createCard(testCard), new ResponseEntity<CardDTO>(this.cardDTO, HttpStatus.CREATED));
        verify(this.service, times(1)).createCard(testCard);
    }

    @Test
    public void deleteCardTestFalse(){
        this.cardController.deleteCard(cardId);
        verify(service, times(1)).deleteCard(cardId);
    }


    @Test
    public void deleteCardTestTrue(){
        when(service.deleteCard(3L)).thenReturn(true);
        this.cardController.deleteCard(3L);
        verify(service, times(1)).deleteCard(3L);
    }

    @Test
    public void getCardByIDTest(){
        when(this.service.findCardById(cardId)).thenReturn(this.cardDTO);
        assertEquals(this.cardController.getCardById(cardId), new ResponseEntity<CardDTO>(this.cardDTO, HttpStatus.OK));
        verify(service, times(1)).findCardById(cardId);
    }

}
