package com.brand.lovie.stickynote.controller;

import com.brand.lovie.stickynote.data.model.Note;
import com.brand.lovie.stickynote.payload.NoteRequest;
import com.brand.lovie.stickynote.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/note")
public class NoteController {

    @Autowired
    NoteService noteService;

    @PostMapping("/")
    public ResponseEntity<?> createNote(@RequestBody NoteRequest noteRequest){
        Note note = noteService.createNote(noteRequest);
        return new ResponseEntity<>(note, HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> updateNote(@PathVariable Long id, @RequestBody NoteRequest noteRequest){
        Note updatedNote = noteService.update(id, noteRequest);
        return new ResponseEntity<>(updatedNote, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable Long id){
        noteService.deleteById(id);
        return new ResponseEntity<>("deleted note", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getNoteById(@PathVariable Long id){
        Note note = noteService.findById(id);
        return  new ResponseEntity<>(note, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<?> getNoteByTitle(@RequestBody String title){
        Note note = noteService.findByTitle(title);
        return new ResponseEntity<>(note, HttpStatus.OK);
    }

    @GetMapping("/all-notes")
    public ResponseEntity<?> getAllNotes(){
        List<Note> noteList = noteService.findAllNotes();
        return new ResponseEntity<>(noteList, HttpStatus.OK);
    }

}
