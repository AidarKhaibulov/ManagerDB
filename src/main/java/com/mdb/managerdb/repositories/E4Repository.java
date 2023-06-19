package com.mdb.managerdb.repositories;

import com.mdb.managerdb.entities.entitiesFor4Task.Employee1NF;
import com.mdb.managerdb.entities.entitiesFor4Task.NF4.Employee4NF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface E4Repository extends JpaRepository<Employee4NF,Long> {
    @Query("SELECT e FROM Employee4NF e ORDER BY e.employeeId")
    List<Employee4NF> findFirstNEmployees(int n);
}
