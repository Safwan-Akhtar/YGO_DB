package org.example.dto;

public class DeckDTO {

    private Long deckId;
    private String deckName;

    public DeckDTO() {
    }

    public DeckDTO(String deckName) {
        this.deckName = deckName;
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
}
