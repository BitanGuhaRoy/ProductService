package com.bitan.pdtserv.clients.authenticationclient;

import com.bitan.pdtserv.clients.authenticationclient.dtos.ResponseValidateTokenRequestDto;
import com.bitan.pdtserv.clients.authenticationclient.dtos.ValidateTokenRequestDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthenticationClient {


     private RestTemplateBuilder restTemplateBuilder;
    public AuthenticationClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public ResponseValidateTokenRequestDto validate(String token, Long userID)
     {
            String url = "http://localhost:9090/auth/validate";

            RestTemplate restTemplate = restTemplateBuilder.build();

         ValidateTokenRequestDto validateTokenRequestDto= new ValidateTokenRequestDto();

         validateTokenRequestDto.setToken(token);

         validateTokenRequestDto.setUserId(userID);

         ResponseEntity<ResponseValidateTokenRequestDto> response = restTemplate.postForEntity(url, validateTokenRequestDto, ResponseValidateTokenRequestDto.class);

            return response.getBody();
     }



}
