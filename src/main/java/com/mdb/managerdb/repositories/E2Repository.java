package com.mdb.managerdb.repositories;

import com.mdb.managerdb.entities.entitiesFor4Task.Employee1NF;
import com.mdb.managerdb.entities.entitiesFor4Task.NF2.Employee2NF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface E2Repository extends JpaRepository<Employee2NF,Long> {
    @Query("SELECT e FROM Employee2NF e ORDER BY e.employeeId")
    List<Employee2NF> findFirstNEmployees(int n);
}
