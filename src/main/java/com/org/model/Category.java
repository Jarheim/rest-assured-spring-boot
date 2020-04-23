package com.org.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category {
    private int id;
    private String name;

    public Category withId(int id) {
        this.id = id;
        return this;
    }

    public Category withName(String name) {
        this.name = name;
        return this;
    }
}
