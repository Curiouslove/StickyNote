package com.brand.lovie.stickynote.exception;

public class NoteException extends RuntimeException{
    public NoteException(){

    }

    public NoteException(String message){
        super(message);
    }
}
