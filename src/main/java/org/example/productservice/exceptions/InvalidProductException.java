package org.example.productservice.exceptions;

public class InvalidProductException extends Exception{
    public InvalidProductException(String message) {
        super(message);
    }
}
