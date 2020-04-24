package com.org.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeletePetResponse {
    private int code;
    private String type;
    private long message;
}
