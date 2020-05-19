package com.qa.service;

import com.qa.dto.CardDTO;
import com.qa.exceptions.CardNotFoundException;
import com.qa.Domain.Card_DB;
import com.qa.repo.CardRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardService {

    private final CardRepo repo;

    private final ModelMapper mapper;

    @Autowired
    public CardService(CardRepo repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    private CardDTO mapToDTO(Card_DB card){
        return this.mapper.map(card, CardDTO.class);
    }

    public List<CardDTO> readCards(){
        return repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public CardDTO createCard(Card_DB card){
        Card_DB tempCard = this.repo.save(card);
        return mapToDTO(tempCard);
    }

    public CardDTO findCardById(Long id){
        return this.mapToDTO(this.repo.findById(id).orElseThrow(CardNotFoundException::new));
    }

    public CardDTO updateCard(Long id, Card_DB card){
        Card_DB update = this.repo.findById(id).orElseThrow(CardNotFoundException::new);
        update.setCardName(card.getCardName());
        update.setCardType(card.getCardType());
        Card_DB tempCard = this.repo.save(card);
        return this.mapToDTO(tempCard);
    }

    public boolean deleteCard(Long id){
        if(!this.repo.existsById(id)){
            throw new CardNotFoundException();
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }

}
