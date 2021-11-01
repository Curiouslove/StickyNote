package com.brand.lovie.stickynote.service;

import com.brand.lovie.stickynote.data.model.Note;
import com.brand.lovie.stickynote.data.repository.NoteRepository;
import com.brand.lovie.stickynote.payload.NoteRequest;
import com.brand.lovie.stickynote.service.mapper.NoteMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteServiceImpl implements NoteService{

    private  NoteRepository noteRepository;


    private  NoteMapper noteMapper;

    @Autowired
    public NoteServiceImpl(NoteRepository noteRepository, NoteMapper noteMapper){
        this.noteRepository = noteRepository;
        this.noteMapper =  noteMapper;
    }


    @Override
    public Note createNote(NoteRequest noteRequest) {
        Note newNote =  new Note();
        noteMapper.mapNoteRequestToNote(noteRequest, newNote);
        noteRepository.save(newNote);
        return newNote;
    }

    @Override
    public Note update(NoteRequest noteRequest) {
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
