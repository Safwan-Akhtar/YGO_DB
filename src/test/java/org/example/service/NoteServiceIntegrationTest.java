package org.example.service;

import org.example.Domain.Card_DB;
import org.example.dto.CardDTO;
import org.example.repo.CardRepo;
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
public class NoteServiceIntegrationTest {

    @Autowired
    private CardService service;

    @Autowired
    private CardRepo repository;

    @Autowired
    private ModelMapper mapper;

    private Card_DB testCard;

    private Card_DB testCardWithID;

    private CardDTO mapToDTO(Card_DB card){
        return this.mapper.map(card, CardDTO.class);
    }

    @Before
    public void setUp(){
        this.testCard = new Card_DB("Card Name", "Card Type");
        this.repository.deleteAll();
        this.testCardWithID = this.repository.save(this.testCard);
    }

    @Test
    public void readCardTest(){
        assertThat(this.service.readCards())
        .isEqualTo(
                Stream.of(this.mapToDTO(testCardWithID)).collect(Collectors.toList())
        );
    }

    @Test
    public void createCardTest(){
        assertEquals(this.mapToDTO(this.testCardWithID), this.service.createCard(testCard));
    }

    @Test
    public void findCardByIdTest(){
        assertThat(this.service.findCardById(this.testCardWithID.getCardId())).isEqualTo(this.mapToDTO(this.testCardWithID));
    }


//    @Test
//    public void updateNoteTest(){
//        Note newNote = new Note("Favourite movies", "The grinch");
//        Note updateNote = new Note(newNote.getTitle(), newNote.getDescription());
//        updateNote.setId(this.testNoteWithID.getId());
//        assertThat(this.service.updateNote(this.testNoteWithID.getId() ,newNote))
//                .isEqualTo(this.mapToDTO(updateNote));
//    }

    @Test
    public void deleteCardTest(){
        assertThat(this.service.deleteCard(this.testCardWithID.getCardId())).isFalse();
    }


}