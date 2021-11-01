package com.brand.lovie.stickynote.service;

import com.brand.lovie.stickynote.data.model.Note;
import com.brand.lovie.stickynote.payload.NoteRequest;

public interface NoteService {
    Note createNote(NoteRequest noteRequest);
    Note update(NoteRequest noteRequest);
    void deleteById(Long id);
    Note findById(Long id);
    Note findByTitle(String title);
}
