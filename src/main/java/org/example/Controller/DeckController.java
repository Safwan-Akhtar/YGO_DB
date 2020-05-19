package org.example.Controller;


import org.example.Domain.Deck;
import org.example.dto.DeckDTO;
import org.example.service.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<DeckDTO>> getAllDecks(){
        return new ResponseEntity<List<DeckDTO>>(this.service.readDeck(), HttpStatus.ACCEPTED);
    }

    @PostMapping("/createDeck")
    public ResponseEntity<DeckDTO> createDeck(@RequestBody Deck deck){
        return new ResponseEntity<DeckDTO>(this.service.createDeck(deck), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteDeck/{id}")
    public ResponseEntity<?> deleteDeck(@PathVariable Long id){
        return this.service.deleteDeck(id)
                ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
                : ResponseEntity.noContent().build();
    }

    @GetMapping("/getDeckById/{id}")
    public ResponseEntity<DeckDTO> getDeckById(@PathVariable Long id){
        return ResponseEntity.ok(this.service.findDeckById(id));
    }

    @PutMapping("/updateDeck/{id}")
    public ResponseEntity<DeckDTO> updateDeck(@PathVariable Long id, @RequestBody Deck deck){
        return ResponseEntity.ok(this.service.updateDeck(id, deck));
    }

}