package org.example.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvalidProductExceptionDto {
    private String message;
    private String detail;
}
