package com.qa.DTOTest;

import com.qa.dto.CardDTO;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class CardDTOtest {

    private CardDTO cardsDTO;
    private CardDTO other;

    @Before
    public void setup(){
        cardsDTO = new CardDTO("card name","card type");
        other = new CardDTO("card name", "card type");
    }

    @Test
    public void settersTest(){

        cardsDTO.setCardId(null);
        assertNull(cardsDTO.getCardId());
        cardsDTO.setCardType(null);
        assertNull(cardsDTO.getCardType());
        cardsDTO.setCardName(null);
        assertNull(cardsDTO.getCardName());
    }

    @Test
    public void equalsWithNull(){
        assertNotEquals(null, cardsDTO);
    }

    @Test
    public void equalsWithDifferentObject() {
        assertNotEquals(cardsDTO, new Object());
    }


    @Test
    public void hashCodeTestWithNull(){
        CardDTO cards = new CardDTO(null, null);
        CardDTO other = new CardDTO(null, null);
        assertEquals(cards.hashCode(), other.hashCode());
    }

    @Test
    public void hashCodeTest(){
        assertEquals(cardsDTO.hashCode(), other.hashCode());
    }

}
