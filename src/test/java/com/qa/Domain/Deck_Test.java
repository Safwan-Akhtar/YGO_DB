package com.qa.Domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;


public class Deck_Test {

    private Deck decks;
    private Deck other;

    @Before
    public void setup(){
        decks = new Deck("deck name");
        other = new Deck("deck name");
    }

    @Test
    public void settersTest(){

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

    @Test
    public void hashCodeTestWithNull(){
        Deck decks = new Deck(null);
        Deck other = new Deck(null);
        assertEquals(decks.hashCode(), other.hashCode());
    }

    @Test
    public void hashCodeTest(){
        assertEquals(decks.hashCode(), other.hashCode());
    }


}