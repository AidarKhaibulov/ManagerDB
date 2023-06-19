package com.mdb.managerdb.entities.entitiesFor4Task.NF4;

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
@Table(name = "employee_addresses_4NF")
public class EmployeeAddress4NF {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long addressId;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee4NF employee;

    @Column(name = "address")
    private String address;
}
