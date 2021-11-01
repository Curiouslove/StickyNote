package com.brand.lovie.stickynote.service;

import com.brand.lovie.stickynote.data.model.Note;

public interface NoteService {

    Note save(Note note);
    Note update(Note note);
    void deleteById(Long id);
    Note findById(Long id);
    Note findByTitle(String title);
}
