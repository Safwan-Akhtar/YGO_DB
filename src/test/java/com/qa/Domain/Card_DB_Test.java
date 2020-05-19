package com.qa.Domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

public class Card_DB_Test {

    private Card_DB cards;
    private Card_DB other;

    @Before
    public void setup(){
        cards = new Card_DB("card name","card type");
        other = new Card_DB("card name", "card type");
    }

    @Test
    public void settersTest(){

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


    @Test
    public void hashCodeTestWithNull(){
        Card_DB cards = new Card_DB(null, null);
        Card_DB other = new Card_DB(null, null);
        assertEquals(cards.hashCode(), other.hashCode());
    }

    @Test
    public void hashCodeTest(){
        assertEquals(cards.hashCode(), other.hashCode());
    }

}
