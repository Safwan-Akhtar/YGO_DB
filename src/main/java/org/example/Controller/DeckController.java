package org.example.Controller;


import org.example.Domain.Deck;
import org.example.service.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeckController {

    private final DeckService service;

    @Autowired
    public DeckController(DeckService service){
        this.service = service;
    }

    @GetMapping("/getAllDecks")
    public List<Deck> getAllDecks(){
        return this.service.readDeck();
    }

    @PostMapping("/createDeck")
    public Deck createDeck(@RequestBody Deck deck){
        return this.service.createDeck(deck);
    }

    @DeleteMapping("/deleteDeck/{id}")
    public boolean deleteDeck(@PathVariable Long id){
        return this.service.deleteDeck(id);
    }

    @GetMapping("/getDeckById/{id}")
    public Deck getDeckById(@PathVariable Long id){
        return this.service.findDeckById(id);
    }

    @PutMapping("/updateDeck/{id}")
    public Deck updateDeck(@PathVariable Long id, @RequestBody Deck deck){
        return this.service.updateDeck(id, deck);
    }

}