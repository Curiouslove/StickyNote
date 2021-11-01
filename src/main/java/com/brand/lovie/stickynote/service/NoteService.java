package com.brand.lovie.stickynote.service;

import com.brand.lovie.stickynote.data.model.Note;
import com.brand.lovie.stickynote.payload.NoteRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NoteService {

    Note createNote(NoteRequest noteRequest);
    Note update(Long id, NoteRequest noteRequest);
    void deleteById(Long id);
    Note findById(Long id);
    Note findByTitle(String title);
    List<Note> findAllNotes();
}
