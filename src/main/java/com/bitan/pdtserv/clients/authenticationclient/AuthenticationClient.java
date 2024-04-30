package com.bitan.pdtserv.clients.authenticationclient;

import com.bitan.pdtserv.clients.authenticationclient.dtos.ResponseValidateTokenRequestDto;
import com.bitan.pdtserv.clients.authenticationclient.dtos.ValidateTokenRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthenticationClient {

//@Autowired
     private RestTemplateBuilder restTemplateBuilder;
    public AuthenticationClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public ResponseValidateTokenRequestDto validate(String token, Long userID)
     {
            String url = "http://localhost:9090/auth/validate";

            RestTemplate restTemplate = restTemplateBuilder.build();
//
         ValidateTokenRequestDto validateTokenRequestDto= new ValidateTokenRequestDto();

         validateTokenRequestDto.setToken(token);

         validateTokenRequestDto.setUserId(userID);
//
//         ResponseEntity<ResponseValidateTokenRequestDto> response = restTemplate.postForEntity(url, validateTokenRequestDto, ResponseValidateTokenRequestDto.class);
//
//            return response.getBody();

         HttpHeaders httpHeaders = new HttpHeaders();
         httpHeaders.setContentType(MediaType.APPLICATION_JSON);

         HttpEntity<ValidateTokenRequestDto> request = new HttpEntity<>(validateTokenRequestDto,  httpHeaders);

         return restTemplate.postForObject(url, request, ResponseValidateTokenRequestDto.class);
     }



}
