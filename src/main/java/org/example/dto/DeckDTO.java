package org.example.dto;

import org.example.Domain.Card_DB;

import java.util.ArrayList;
import java.util.List;

public class DeckDTO {

    private Long deckId;
    private String deckName;
    private List<Card_DB> cards = new ArrayList<>();

    public DeckDTO() {
    }

    public DeckDTO(String deckName) {
        this.deckName = deckName;
    }

    public DeckDTO(String deckName, List<Card_DB> cards) {
        this.deckName = deckName;
        this.cards = cards;
    }

    public Long getDeckId() {
        return deckId;
    }

    public void setDeckId(Long deckId) {
        this.deckId = deckId;
    }

    public String getDeckName() {
        return deckName;
    }

    public void setDeckName(String deckName) {
        this.deckName = deckName;
    }

    public List<Card_DB> getCards() {
        return cards;
    }

    public void setCards(List<Card_DB> cards) {
        this.cards = cards;
    }
}
