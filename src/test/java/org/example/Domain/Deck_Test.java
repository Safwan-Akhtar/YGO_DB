package org.example.Domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;


public class Deck_Test {

    private Deck decks;

    @Before
    public void setup(){
        decks = new Deck("deck name");
    }

    @Test
    public void settersTest(){
        assertNotNull(decks.getDeckId());
        assertNotNull(decks.getDeckName());

        decks.setDeckId(null);
        assertNull(decks.getDeckId());
        decks.setDeckName(null);
        assertNull(decks.getDeckName());
    }

    @Test
    public void equalsWithNull(){
        assertNotEquals(null, decks);
    }

    @Test
    public void equalsWithDifferentObject() {
        assertNotEquals(decks, new Object());
    }

}