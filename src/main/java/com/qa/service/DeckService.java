package com.qa.service;

import com.qa.Domain.Deck;
import com.qa.dto.DeckDTO;
import com.qa.exceptions.DeckNotFoundException;
import com.qa.repo.DeckRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeckService {

    private final DeckRepo repo;

    private final ModelMapper mapper;


    @Autowired
    public DeckService(DeckRepo repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    private DeckDTO mapToDTO(Deck deck){
        return this.mapper.map(deck, DeckDTO.class);
    }

    public List<DeckDTO> readDeck(){
        return repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public DeckDTO createDeck(Deck deck){
        return this.mapToDTO(this.repo.save(deck));
    }

    public DeckDTO findDeckById(Long id){
        return this.mapToDTO(this.repo.findById(id).orElseThrow(DeckNotFoundException::new));
    }

    public DeckDTO updateDeck(Long id, Deck deck){
        Deck update = this.repo.findById(id).orElseThrow(DeckNotFoundException::new);
        update.setDeckName(deck.getDeckName());
        Deck tempDeck = this.repo.save(update);
        return this.mapToDTO(tempDeck);
    }

    public boolean deleteDeck(Long id){
        if(!this.repo.existsById(id)){
            throw new DeckNotFoundException();
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }

}
