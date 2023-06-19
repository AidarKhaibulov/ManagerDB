package com.mdb.managerdb.entities.entitiesFor4Task;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees_1NF")
public class Employee1NF {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column(name = "department", length = 50)
    private String department;

    @Column(name = "position", length = 50)
    private String position;

    @Column(name = "salary", precision = 10, scale = 2)
    private BigDecimal salary;

    @Column(name = "hire_date")
    private Date hireDate;

    @Column(name = "address", length = 100)
    private String address;

    @Column(name = "phone", length = 20)
    private String phone;
}
