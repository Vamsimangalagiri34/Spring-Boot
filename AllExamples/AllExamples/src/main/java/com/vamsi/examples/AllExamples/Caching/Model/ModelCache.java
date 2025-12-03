package com.vamsi.examples.AllExamples.Caching.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity

public class ModelCache {

    @Id
    int id;
    String name;

    public ModelCache(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ModelCache() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
