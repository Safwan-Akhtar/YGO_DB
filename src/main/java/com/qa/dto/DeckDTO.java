package com.qa.dto;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeckDTO deckDTO = (DeckDTO) o;
        return deckId.equals(deckDTO.deckId) &&
                deckName.equals(deckDTO.deckName) &&
                cards.equals(deckDTO.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deckId, deckName, cards);
    }
}
