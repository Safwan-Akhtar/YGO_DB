package org.example.Domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Deck {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long deckId;

    private String deckName;

    public Deck() {
    }

    public Deck(String deckName) {
        this.deckName = deckName;
    }

    @OneToMany(mappedBy = "deck", fetch = FetchType.LAZY)
    private List<Card_DB> cards = new ArrayList<>();

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
