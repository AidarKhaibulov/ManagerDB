package com.mdb.managerdb.entities.entitiesFor4Task.NF5;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee_salaries_5NF")
public class EmployeeSalary5NF {
    @Id
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee5NF employee;

    @Column(name = "salary")
    private BigDecimal salary;

    @Column(name = "hire_date")
    private LocalDate hireDate;
}
