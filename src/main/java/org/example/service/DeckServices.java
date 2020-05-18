package org.example.service;

import org.example.Domain.Card_DB;
import org.example.Domain.Deck;
import org.example.exceptions.CardNotFoundException;
import org.example.exceptions.DeckNotFoundException;
import org.example.repo.DeckRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeckServices {

    private final DeckRepo repo;

    @Autowired
    public DeckServices(DeckRepo repo) {
        this.repo = repo;
    }

    public List<Deck> readDeck(){
        return repo.findAll();
    }

    public Deck createDeck(Deck deck){
        return this.repo.save(deck);
    }

    public Deck findDeckById(Long id){
        return this.repo.findById(id).orElseThrow(DeckNotFoundException::new);
    }

    public Deck updateDeck(Long id, Deck deck){
        Deck update = findDeckById(id);
        update.setDeckName(deck.getDeckName());
        return this.repo.save(update);
    }

    public boolean deleteDeck(Long id){
        if(!this.repo.existsById(id)){
            throw new DeckNotFoundException();
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }

}
