package com.mdb.managerdb.entities.entitiesFor4Task.NF5;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee_positions_5NF")
public class EmployeePosition5NF {
    @Id
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee5NF employee;

    @Id
    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position5NF position;
}
