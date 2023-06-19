package com.mdb.managerdb.entities.entitiesFor4Task.NF3;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee_details_3NF")
public class EmployeeDetails3NF {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId;

    @OneToOne
    @JoinColumn(name = "employee_id")
    @MapsId
    private Employee3NF employee;

    @Column(name = "salary")
    private BigDecimal salary;

    @Column(name = "hire_date")
    private LocalDate hireDate;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position3NF position;
}
