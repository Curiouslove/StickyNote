package com.brand.lovie.stickynote.data.repository;

import com.brand.lovie.stickynote.data.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
    Note findByTitle(String title);
}
