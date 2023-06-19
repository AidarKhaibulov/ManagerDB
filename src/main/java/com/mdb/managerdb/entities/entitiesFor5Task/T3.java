package com.mdb.managerdb.entities.entitiesFor5Task;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "T3")
public class T3 {
    @Id
    @Column(name = "index")
    private String index;

    @Column(name = "data")
    private String data;
}
