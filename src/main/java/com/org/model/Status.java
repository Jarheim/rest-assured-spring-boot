package com.org.model;

import lombok.Getter;

@Getter
public enum Status {
    avail("available"),
    pending("pending"),
    sold("sold");

    private String value;

    Status(String value) {
        this.value = value;
    }
}
