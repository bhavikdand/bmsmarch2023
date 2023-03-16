package com.example.bmsmarch2023.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {

    private ResponseStatus status;
    private String message;
}
