package com.brand.lovie.stickynote.service.mapper;


import com.brand.lovie.stickynote.data.model.Note;
import com.brand.lovie.stickynote.payload.NoteRequest;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface NoteMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void mapNoteRequestToNote(NoteRequest noteRequest, @MappingTarget Note note);
}
