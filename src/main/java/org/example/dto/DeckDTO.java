package org.example.dto;


import java.util.ArrayList;
import java.util.List;

public class DeckDTO {

    private Long deckId;
    private String deckName;
    private List<CardDTO> cards = new ArrayList<>();

    public DeckDTO() {
    }

    public DeckDTO(String deckName) {
        this.deckName = deckName;
    }

    public DeckDTO(String deckName, List<CardDTO> cards) {
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

    public List<CardDTO> getCards() {
        return cards;
    }

    public void setCards(List<CardDTO> cards) {
        this.cards = cards;
    }
}
