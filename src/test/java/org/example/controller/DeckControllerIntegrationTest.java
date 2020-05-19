package org.example.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Domain.Deck;
import org.example.dto.DeckDTO;
import org.example.repo.DeckRepo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DeckControllerIntegrationTest {

    @Autowired
    private MockMvc mock;

    @Autowired
    private DeckRepo repository;

    @Autowired
    private ModelMapper mapper;

    private ObjectMapper objectMapper = new ObjectMapper();

    private Deck testDeck;

    private Deck testDeckWithID;

    private long deckId;

    private DeckDTO deckDTO;

    private DeckDTO mapToDTO(Deck deck){
        return this.mapper.map(deck, DeckDTO.class);
    }

    @Before
    public void setUp(){
        this.repository.deleteAll();
        this.testDeck = new Deck("test deckName");
        this.testDeckWithID = this.repository.save(testDeck);
        this.deckId = testDeckWithID.getDeckId();
        this.deckDTO = this.mapToDTO(testDeckWithID);
    }

    @Test
    public void getAllDecksTest() throws Exception {
        List<DeckDTO> deckDTOList = new ArrayList<>();
        deckDTOList.add(deckDTO);
        String content;
        content = this.mock.perform(
                request(HttpMethod.GET, "/getAllDecks")
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertEquals(content, this.objectMapper.writeValueAsString(deckDTOList));
    }

    @Test
    public void getDeckByID() throws Exception {
        String content = this.mock.perform(
                request(HttpMethod.GET, "/getDeckById/" + this.deckId)
                .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isOk())
            .andReturn()
            .getResponse()
            .getContentAsString();
        assertEquals(content, this.objectMapper.writeValueAsString(deckDTO));
    }

    @Test
    public void createDeckTest() throws Exception {
        String result = this.mock.perform(
                request(HttpMethod.POST, "/createDeck")
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(testDeck))
                .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isCreated())
            .andReturn()
            .getResponse()
            .getContentAsString();
        assertEquals(result, this.objectMapper.writeValueAsString(deckDTO));
    }

    @Test
    public void deleteDeckTest() throws Exception {
        this.mock.perform(
                request(HttpMethod.DELETE, "/deleteDeck/" + this.deckId)
        ).andExpect(status().isNoContent());
    }


}
