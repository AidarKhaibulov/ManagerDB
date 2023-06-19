package com.mdb.managerdb.entities.entitiesFor5Task;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
public class T2Id implements Serializable {
    private String value;

    public T2Id(String value) {
        this.value=value;
    }
}

