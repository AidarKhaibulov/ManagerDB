package com.mdb.managerdb.repositories;

import com.mdb.managerdb.entities.entitiesFor4Task.Employee1NF;
import com.mdb.managerdb.entities.entitiesFor4Task.NF4.Employee4NF;
import com.mdb.managerdb.entities.entitiesFor4Task.NF5.Employee5NF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface E5Repository extends JpaRepository<Employee5NF,Long> {
    @Query("SELECT e FROM Employee5NF e ORDER BY e.employeeId")
    List<Employee5NF> findFirstNEmployees(int n);
}
