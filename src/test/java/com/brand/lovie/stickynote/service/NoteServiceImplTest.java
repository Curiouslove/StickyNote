package com.brand.lovie.stickynote.service;

import com.brand.lovie.stickynote.data.model.Note;
import com.brand.lovie.stickynote.data.repository.NoteRepository;
import com.brand.lovie.stickynote.exception.NoteException;
import com.brand.lovie.stickynote.payload.NoteRequest;
import com.brand.lovie.stickynote.service.mapper.NoteMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
@Sql(scripts = {"/db/insert.sql"})
class NoteServiceImplTest {

    @Autowired
    NoteService noteService;
    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createNote() {
        NoteRequest noteRequest = new NoteRequest();
        noteRequest.setTitle("testing note");
        noteRequest.setContent("contenting");
        Note createdNote = noteService.createNote(noteRequest);
        assertThat(createdNote.getId()).isNotNull();
        assertThat(createdNote.getTitle()).isEqualTo(noteRequest.getTitle());
    }

    @Test
    void update() {
        NoteRequest noteRequest = new NoteRequest();
        noteRequest.setContent("a new content");

        Note updatedNote = noteService.update(110L, noteRequest);

        assertThat(updatedNote.getContent()).isEqualTo(noteRequest.getContent());
        assertThat(updatedNote.getTitle()).isNotNull();
    }

    @Test
    void deleteById() {
       Note note = noteService.findById(110L);
       assertThat(note).isNotNull();

       noteService.deleteById(note.getId());
       assertThrows(NoteException.class, ()-> noteService.findById(note.getId()));
    }

    @Test
    void findById() {
        Note foundNote =  noteService.findById(112L);
        assertThat(foundNote.getId()).isNotNull();
        assertThat(foundNote.getId()).isEqualTo(112L);
        assertThat(foundNote.getTitle()).isNotNull();
    }

    @Test
    void findByWrongId() {
        try {
            Note foundNote = noteService.findById(5L);
            assertThrows(NoteException.class, () -> noteService.findById(foundNote.getId()));
        }catch (NoteException e){
            e.getMessage();
        }
    }

    @Test
    void findByTitle() {
        Note foundNote = noteService.findByTitle("luxury table");

        assertThat(foundNote.getTitle()).isEqualTo("luxury table");
        assertThat(foundNote.getId()).isNotNull();
    }
}