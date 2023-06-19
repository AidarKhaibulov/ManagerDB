package com.mdb.managerdb.repositories;

import com.mdb.managerdb.entities.entitiesFor4Task.Employee1NF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface E1Repository extends JpaRepository<Employee1NF,Long> {
    @Query("SELECT e FROM Employee1NF e ORDER BY e.employeeId")
    List<Employee1NF> findFirstNEmployees(int n);
}
