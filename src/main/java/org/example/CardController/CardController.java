package org.example.CardController;

import org.example.Domain.Card_DB;
import org.example.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Card_DB> getAllCards(){
        return this.service.readCards();
    }

    @PostMapping("/createCard")
    public Card_DB createCard(@RequestBody Card_DB card){
        return this.service.createCard(card);
    }

    @DeleteMapping("/deleteCard/{id}")
    public boolean deleteCard(@PathVariable Long id){
        return this.service.deleteCard(id);
    }

    @GetMapping("/getCardById/{id}")
    public Card_DB getCardById(@PathVariable Long id){
        return this.service.findCardById(id);
    }

    @PutMapping("/updateCard/{id}")
    public Card_DB updateCard(@PathVariable Long id, @RequestBody Card_DB card){
        return this.service.updateCard(id, card);
    }

}