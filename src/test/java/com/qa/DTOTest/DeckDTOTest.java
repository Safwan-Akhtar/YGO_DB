package com.qa.DTOTest;

import com.qa.dto.DeckDTO;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class DeckDTOTest {

        private DeckDTO decks;
        private DeckDTO other;

        @Before
        public void setup(){
            decks = new DeckDTO("deck name");
            other = new DeckDTO("deck name");
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
            DeckDTO decks = new DeckDTO(null);
            DeckDTO other = new DeckDTO(null);
            assertEquals(decks.hashCode(), other.hashCode());
        }

        @Test
        public void hashCodeTest(){
            assertEquals(decks.hashCode(), other.hashCode());
        }


    }