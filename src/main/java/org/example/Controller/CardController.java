package org.example.Controller;

import org.example.Domain.Card_DB;
import org.example.dto.CardDTO;
import org.example.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CardController {

    private final CardService service;

    @Autowired
    public CardController(CardService service) {
        this.service = service;
    }

    @GetMapping("/getAllCards")
    public ResponseEntity<List<CardDTO>> getAllCards(){
        return ResponseEntity.ok(this.service.readCards());
    }

    @PostMapping("/createCard")
    public ResponseEntity<CardDTO> createCard(@RequestBody Card_DB card){
        return new ResponseEntity<CardDTO>(this.service.createCard(card), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteCard/{id}")
    public ResponseEntity<?> deleteCard(@PathVariable Long id){
        return this.service.deleteCard(id)
                ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
                : ResponseEntity.noContent().build();
    }

    @GetMapping("/getCardById/{id}")
    public ResponseEntity<CardDTO> getCardById(@PathVariable Long id){
        return ResponseEntity.ok(this.service.findCardById(id));
    }

    @PutMapping("/updateCard/{id}")
    public ResponseEntity<CardDTO> updateCard(@PathVariable Long id, @RequestBody Card_DB card){
        return ResponseEntity.ok(this.service.updateCard(id, card));
    }

}