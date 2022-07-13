package com.example.Randomwordgenerator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserDto {

    @JsonProperty("username")
    private String username;


    @JsonProperty("email")
    private String email;


}
