package com.qa.dto;


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


}
