package org.example.service;

import org.example.Domain.Card_DB;
import org.example.exceptions.CardNotFoundException;
import org.example.repo.CardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    private final CardRepo repo;

    @Autowired
    public CardService(CardRepo repo) {
        this.repo = repo;
    }

    public List<Card_DB> readCards(){
        return repo.findAll();
    }

    public Card_DB createCard(Card_DB card){
        return this.repo.save(card);
    }

    public Card_DB findCardById(Long id){
        return this.repo.findById(id).orElseThrow(CardNotFoundException::new);
    }

    public Card_DB updateCard(Long id, Card_DB card){
        Card_DB update = findCardById(id);
        update.setCardName(card.getCardName());
        update.setCardType(card.getCardType());
        return this.repo.save(update);
    }

    public boolean deleteCard(Long id){
        if(!this.repo.existsById(id)){
            throw new CardNotFoundException();
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }

}
