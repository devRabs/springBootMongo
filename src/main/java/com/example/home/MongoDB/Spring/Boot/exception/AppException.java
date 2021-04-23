package com.example.home.MongoDB.Spring.Boot.exception;

public class AppException extends Exception{
    public AppException(String message){
        super(message);
    }
    public AppException(String message, Throwable t){
        super(message,t);
    }
}
