package com.org.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Pet {
    private long id;
    private Category category;
    private String name;
    private List<String> photoUrls = null;
    private List<Tag> tags = null;
    private String status = Status.avail.getValue();

    public static Pet aPet() {
        return new Pet();
    }

    public Pet withId(int id) {
        this.id = id;
        return this;
    }

    public Pet withCategory(Category category) {
        this.category = category;
        return this;
    }

    public Pet withName(String name) {
        this.name = name;
        return this;
    }

    public Pet withPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
        return this;
    }

    public Pet withTags(List<Tag> tags) {
        this.tags = tags;
        return this;
    }

    public Pet withStatus(Status status) {
        this.status = status.getValue();
        return this;
    }

}
