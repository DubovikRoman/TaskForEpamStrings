package com.dubovik.strings.exception;

public class InvalidDataException extends Exception{

    public InvalidDataException(){
        super();
    }

    public InvalidDataException(Throwable e){
        super(e);
    }

    public InvalidDataException(String exception){
        super(exception);
    }

    public InvalidDataException(Throwable e, String exception){
        super(exception, e);
    }
}
