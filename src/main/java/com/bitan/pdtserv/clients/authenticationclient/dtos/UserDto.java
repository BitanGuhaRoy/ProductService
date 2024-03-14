package com.bitan.pdtserv.clients.authenticationclient.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
@Getter
@Setter
public class UserDto {
    private String email;
    //    private String message;
    private HashSet<Role> roles= new HashSet<>();
//    public UserDto(){
//        this.roles= new HashSet<>();
//    }


}
