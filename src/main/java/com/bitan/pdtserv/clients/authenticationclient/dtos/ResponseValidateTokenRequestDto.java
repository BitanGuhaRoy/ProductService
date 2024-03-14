package com.bitan.pdtserv.clients.authenticationclient.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseValidateTokenRequestDto {
    private UserDto userDto;
    private SessionStatus sessionStatus;
}
