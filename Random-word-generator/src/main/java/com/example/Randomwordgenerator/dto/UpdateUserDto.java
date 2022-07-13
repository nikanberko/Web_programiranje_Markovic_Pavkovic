package com.example.Randomwordgenerator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Optional;

@Data
public class UpdateUserDto {

    @JsonProperty("username")
    private Optional<String> optionalUsername = Optional.empty();

    @JsonProperty("email")
    private Optional<String> optionalEmail = Optional.empty();



}
