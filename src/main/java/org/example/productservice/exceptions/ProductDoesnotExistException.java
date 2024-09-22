package org.example.productservice.exceptions;

public class ProductDoesnotExistException extends Exception{
    public ProductDoesnotExistException(String message){
        super(message);
    }
}
