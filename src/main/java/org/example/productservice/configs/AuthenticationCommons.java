package org.example.productservice.configs;

import org.example.productservice.dtos.User;
import org.example.productservice.dtos.UserDto;
import org.example.productservice.dtos.ValidateTokenRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Component
public class AuthenticationCommons {

    @Autowired
    private RestTemplate restTemplate;
    public UserDto valiedateToken(String token) {
        ValidateTokenRequestDto validateTokenRequestDto = new ValidateTokenRequestDto();
        validateTokenRequestDto.setToken(token);
        URI uri = URI.create("http://localhost:3030/users/validateToken");

//        ResponseEntity<UserDto> userDtoResponseEntity =  restTemplate.postForEntity("http://localhost:3030/users/validateToken", validateTokenRequestDto, UserDto.class);
        ResponseEntity<UserDto> response = restTemplate.postForEntity(
                uri,               // URI of the endpoint
                validateTokenRequestDto,  // The request body
                UserDto.class      // The response type
        );

        if(response.getBody()==null)
       {
           return null;
       }
       return response.getBody();


    }
}
