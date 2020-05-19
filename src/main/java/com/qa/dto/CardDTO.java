package com.qa.dto;


import java.util.Objects;

public class CardDTO {

    private Long cardId;
    private String cardName;
    private String cardType;

    public CardDTO() {
    }

    public CardDTO(String cardName, String cardType) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardDTO cardDTO = (CardDTO) o;
        return cardId.equals(cardDTO.cardId) &&
                cardName.equals(cardDTO.cardName) &&
                cardType.equals(cardDTO.cardType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId, cardName, cardType);
    }
}
