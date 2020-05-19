package com.qa.Domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Card_DB {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cardId;

    private String cardName;
    private String cardType;

    @ManyToOne(targetEntity = Deck.class)
    private Deck deck;

    public Card_DB() {
    }

    public Card_DB(String cardName, String cardType) {
        this.cardName = cardName;
        this.cardType = cardType;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card_DB card_db = (Card_DB) o;
        return cardId.equals(card_db.cardId) &&
                cardName.equals(card_db.cardName) &&
                cardType.equals(card_db.cardType) &&
                deck.equals(card_db.deck);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId, cardName, cardType, deck);
    }
}
