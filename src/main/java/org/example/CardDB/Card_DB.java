package org.example.CardDB;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Card_DB {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cardId;
//    private Long userId;
    private String cardName;
    private String cardType;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card_DB card_db = (Card_DB) o;
        return cardId.equals(card_db.cardId) &&
                cardName.equals(card_db.cardName) &&
                cardType.equals(card_db.cardType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId, cardName, cardType);
    }
}
