package com.brand.lovie.stickynote.service;

import com.brand.lovie.stickynote.data.model.Note;
import com.brand.lovie.stickynote.data.repository.NoteRepository;
import com.brand.lovie.stickynote.payload.NoteRequest;
import com.brand.lovie.stickynote.service.mapper.NoteMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class NoteServiceImplTest {

    @Autowired
    NoteRepository noteRepository;
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
    }

    @Test
    void deleteById() {
    }

    @Test
    void findById() {
    }

    @Test
    void findByTitle() {
    }
}