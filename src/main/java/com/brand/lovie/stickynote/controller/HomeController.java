package com.brand.lovie.stickynote.controller;

import com.brand.lovie.stickynote.data.model.Note;
import com.brand.lovie.stickynote.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    @Autowired
    NoteService noteService;

    @GetMapping("/notes/{id}")
    public String getNote(@PathVariable Long id, Model model){
        Note note = noteService.findById(id);
        model.addAttribute("note", note);
        return "note";
    }


}
