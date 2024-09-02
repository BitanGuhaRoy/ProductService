package org.example.productservice.advice;
import org.example.productservice.dtos.ArithmeticExceptionDto;
import org.example.productservice.dtos.ArrayIndexOutOfBoundExceptionDto;
import org.example.productservice.dtos.InvalidProductExceptionDto;
import org.example.productservice.exceptions.InvalidProductException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {


    @ExceptionHandler(ArithmeticException.class)
     public ResponseEntity<ArithmeticExceptionDto> handleArithmeticException()
     {
         ArithmeticExceptionDto arithmeticExceptionDto = new ArithmeticExceptionDto();
         arithmeticExceptionDto.setMessage("Arithmetic Exception");

        return new ResponseEntity<>(arithmeticExceptionDto, HttpStatus.BAD_REQUEST);
     }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<ArrayIndexOutOfBoundExceptionDto> handleArrayIndexOutOfBoundException()
    {
        ArrayIndexOutOfBoundExceptionDto arrayIndexOutOfBoundExceptionDto = new ArrayIndexOutOfBoundExceptionDto();
        arrayIndexOutOfBoundExceptionDto.setMessage("Array Index Out Of Bound Exception");

        return new ResponseEntity<>(arrayIndexOutOfBoundExceptionDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidProductException.class)
    public ResponseEntity<InvalidProductExceptionDto> handleInvalidProductException()
    {
        InvalidProductExceptionDto invalidProductExceptionDto = new InvalidProductExceptionDto();
        invalidProductExceptionDto.setMessage("product not found");

        return new ResponseEntity<>(invalidProductExceptionDto, HttpStatus.NOT_FOUND);
    }

}
