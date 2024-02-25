package org.test.exception;

public class InvalidUserInput extends Exception{
    public InvalidUserInput(String message){
        super(message);
    }
}
