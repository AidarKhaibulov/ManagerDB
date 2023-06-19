package com.mdb.managerdb.repositories;

import com.mdb.managerdb.entities.entitiesFor4Task.Employee1NF;
import com.mdb.managerdb.entities.entitiesFor4Task.NF2.Employee2NF;
import com.mdb.managerdb.entities.entitiesFor4Task.NF3.Employee3NF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface E3Repository extends JpaRepository<Employee3NF,Long> {
    @Query("SELECT e FROM Employee3NF e ORDER BY e.employeeId")
    List<Employee3NF> findFirstNEmployees(int n);
}
