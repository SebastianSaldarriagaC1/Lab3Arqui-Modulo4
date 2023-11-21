package com.udea.lab3.exception;

public class InvalidRating extends RuntimeException{
    public InvalidRating(){
        super();
    }

    public InvalidRating(String message){
        super(message);
    }
}
