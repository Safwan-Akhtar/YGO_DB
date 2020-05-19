package com.qa.service;

import com.qa.Domain.Deck;
import com.qa.dto.DeckDTO;
import com.qa.repo.DeckRepo;
import com.qa.service.DeckService;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeckServiceIntegrationTest {

    @Autowired
    private DeckService service;

    @Autowired
    private DeckRepo repository;

    @Autowired
    private ModelMapper mapper;

    private Deck testDeck;

    private Deck testDeckWithID;

    private DeckDTO mapToDTO(Deck deck){
        return this.mapper.map(deck, DeckDTO.class);
    }

    @Before
    public void setUp(){
        this.testDeck = new Deck("Deck Name");
        this.repository.deleteAll();
        this.testDeckWithID = this.repository.save(this.testDeck);
    }

    @Test
    public void readDeckTest(){
        Assertions.assertThat(this.service.readDeck())
        .isEqualTo(
                Stream.of(this.mapToDTO(testDeckWithID)).collect(Collectors.toList())
        );
    }

    @Test
    public void createDeckTest(){
        Assert.assertEquals(this.mapToDTO(this.testDeckWithID), this.service.createDeck(testDeck));
    }

    @Test
    public void findDeckByIdTest(){
        Assertions.assertThat(this.service.findDeckById(this.testDeckWithID.getDeckId())).isEqualTo(this.mapToDTO(this.testDeckWithID));
    }


    @Test
    public void updateDeckTest(){
        Deck newDeck = new Deck("Favourite deck");
        Deck updateDeck = new Deck(newDeck.getDeckName());
        updateDeck.setDeckId(this.testDeckWithID.getDeckId());
        Assertions.assertThat(this.service.updateDeck(this.testDeckWithID.getDeckId() ,newDeck))
                .isEqualTo(this.mapToDTO(updateDeck));
    }

    @Test
    public void deleteDeckTest(){
        assertThat(this.service.deleteDeck(this.testDeckWithID.getDeckId())).isFalse();
    }


}
