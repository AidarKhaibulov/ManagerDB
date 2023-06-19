package com.mdb.managerdb.entities.entitiesFor4Task.NF4;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee_salaries_4NF")
public class EmployeeSalary4NF {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "salary_id")
    private Long salaryId;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private EmployeeDetails4NF employeeDetails;

    @Column(name = "salary")
    private BigDecimal salary;
}
