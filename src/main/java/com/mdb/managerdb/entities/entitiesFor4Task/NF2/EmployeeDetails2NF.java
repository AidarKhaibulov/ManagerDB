package com.mdb.managerdb.entities.entitiesFor4Task.NF2;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees_details_2NF")
public class EmployeeDetails2NF {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "department", length = 50)
    private String department;

    @Column(name = "position", length = 50)
    private String position;

    @Column(name = "salary")
    private BigDecimal salary;

    @Column(name = "hire_date")
    private Date hireDate;
}
