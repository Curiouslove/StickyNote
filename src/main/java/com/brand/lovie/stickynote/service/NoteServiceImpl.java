package com.brand.lovie.stickynote.service;

import com.brand.lovie.stickynote.data.model.Note;
import com.brand.lovie.stickynote.data.repository.NoteRepository;
import org.springframework.stereotype.Service;

@Service
public class NoteServiceImpl implements NoteService{

    private NoteRepository noteRepository;

    public NoteServiceImpl(NoteRepository noteRepository){
        this.noteRepository = noteRepository;
    }


    @Override
    public Note save(Note note) {
        return null;
    }

    @Override
    public Note update(Note note) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Note findById(Long id) {
        return null;
    }

    @Override
    public Note findByTitle(String title) {
        return null;
    }
}
