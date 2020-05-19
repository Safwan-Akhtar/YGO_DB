package org.example.service;

import org.example.Domain.Deck;
import org.example.dto.DeckDTO;
import org.example.exceptions.DeckNotFoundException;
import org.example.repo.DeckRepo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class DeckServiceUnitTest {

    @InjectMocks
    private DeckService service;

    @Mock
    private DeckRepo repository;

    @Mock
    private ModelMapper mapper;

    private List<Deck> deckList;

    private Deck testDeck;

    private long deckId = 1L;

    private Deck testDeckWithID;

    private DeckDTO deckDTO;

    private DeckDTO mapToDTO(Deck deck){
        return this.mapper.map(deck, DeckDTO.class);
    }

    @Before
    public void setUp(){
        this.deckList = new ArrayList<>();
        this.testDeck = new Deck("Card name");
        this.deckList.add(testDeck);
        this.testDeckWithID = new Deck(testDeck.getDeckName());
        this.testDeckWithID.setDeckId(deckId);
        this.deckDTO = this.mapToDTO(testDeckWithID);
    }

    @Test
    public void getAllDecksTest(){
        when(repository.findAll()).thenReturn(this.deckList);
        when(this.mapper.map(testDeckWithID, DeckDTO.class)).thenReturn(deckDTO);
        assertFalse("Service returned no Decks", this.service.readDeck().isEmpty());
        verify(repository, times(1)).findAll();
    }

    @Test
    public void createDeckTest(){
        when(repository.save(testDeck)).thenReturn(testDeckWithID);
        when(this.mapper.map(testDeckWithID, DeckDTO.class)).thenReturn(deckDTO);
        assertEquals(this.service.createDeck(testDeck), this.deckDTO);
        verify(repository, times(1)).save(this.testDeck);
    }

    @Test
    public void findDeckByIdTest(){
        when(this.repository.findById(deckId)).thenReturn(java.util.Optional.ofNullable(testDeckWithID));
        when(this.mapper.map(testDeckWithID, DeckDTO.class)).thenReturn(deckDTO);
        assertEquals(this.service.findDeckById(this.deckId), deckDTO);
        verify(repository, times(1)).findById(deckId);
    }

    @Test
    public void deleteDeckByExistingId(){
        when(this.repository.existsById(deckId)).thenReturn(true, false);
        assertFalse(service.deleteDeck(deckId));
        verify(repository, times(1)).deleteById(deckId);
        verify(repository, times(2)).existsById(deckId);
    }

    @Test(expected = DeckNotFoundException.class)
    public void deleteDeckByNonExistingId(){
        when(this.repository.existsById(deckId)).thenReturn(false);
        service.deleteDeck(deckId);
        verify(repository, times(1)).existsById(deckId);
    }

//    @Test
//    public void updateNoteTest(){
//
//        Note newNote = new Note("Favourite movies", "The grinch");
//        Note updateNote = new Note(newNote.getTitle(), newNote.getDescription());
//        updateNote.setId(id);
//
//        NoteDTO updateNoteDTO = new ModelMapper().map(updateNote, NoteDTO.class);
//
//        when(this.repository.findById(id)).thenReturn(java.util.Optional.ofNullable(testNoteWithID));
//        when(this.repository.save(updateNote)).thenReturn(updateNote);
//        when(this.mapper.map(updateNote, NoteDTO.class)).thenReturn(updateNoteDTO);
//
//        assertEquals(updateNoteDTO, this.service.updateNote(id, newNote));
//        verify(this.repository, times(1)).findById(id);
//        verify(this.repository, times(1)).save(updateNote);
//    }

}
