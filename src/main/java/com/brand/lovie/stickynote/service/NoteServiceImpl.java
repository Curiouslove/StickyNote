package com.brand.lovie.stickynote.service;

import com.brand.lovie.stickynote.data.model.Note;
import com.brand.lovie.stickynote.data.repository.NoteRepository;
import com.brand.lovie.stickynote.exception.NoteException;
import com.brand.lovie.stickynote.payload.NoteRequest;
import com.brand.lovie.stickynote.service.mapper.NoteMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public Note update(Long id, NoteRequest noteRequest) {
        Note noteToUpdate = findById(id);
        noteMapper.mapNoteRequestToNote(noteRequest, noteToUpdate);
        noteRepository.save(noteToUpdate);
        return noteToUpdate;
    }

    @Override
    public void deleteById(Long id) {
      Note foundNote = findById(id);
        if(foundNote != null) {
            noteRepository.deleteById(foundNote.getId());
        }else{
            throw new NoteException("Note not found");
        }
    }

    @Override
    public Note findById(Long id) {
        Note foundNote =  noteRepository.findById(id).orElse(null);
        if(foundNote != null) {
            return foundNote;
        }else{
            throw new NoteException("Note not found");
        }

    }

    @Override
    public Note findByTitle(String title) {
        Note foundNote =  noteRepository.findByTitle(title);
        if(foundNote != null) {
            return foundNote;
        }else{
            throw new NoteException("Note not found");
        }
    }
}
