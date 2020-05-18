package org.example.CardController;

import org.example.CardDB.Card_DB;
import org.example.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}