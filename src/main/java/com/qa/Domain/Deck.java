package com.qa.Domain;

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

    @OneToMany(mappedBy = "deck", fetch = FetchType.EAGER)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deck deck = (Deck) o;
        return deckId.equals(deck.deckId) &&
                deckName.equals(deck.deckName) &&
                cards.equals(deck.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deckId, deckName, cards);
    }
}
