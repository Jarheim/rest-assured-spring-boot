package com.org.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tag {
    public int id;
    public String name;

    public Tag withId(int id) {
        this.id = id;
        return this;
    }

    public Tag withName(String name) {
        this.name = name;
        return this;
    }
}
