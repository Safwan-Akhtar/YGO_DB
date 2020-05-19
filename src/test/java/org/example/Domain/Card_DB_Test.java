package org.example.Domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

public class Card_DB_Test {

    private Card_DB cards;

    @Before
    public void setup(){
        cards = new Card_DB("card name","card type");
    }

    @Test
    public void settersTest(){
        assertNotNull(cards.getCardId());
        assertNotNull(cards.getCardName());
        assertNotNull(cards.getCardType());

        cards.setCardId(null);
        assertNull(cards.getCardId());
        cards.setCardType(null);
        assertNull(cards.getCardType());
        cards.setCardName(null);
        assertNull(cards.getCardName());
    }

    @Test
    public void equalsWithNull(){
        assertNotEquals(null, cards);
    }

    @Test
    public void equalsWithDifferentObject() {
        assertNotEquals(cards, new Object());
    }

}
