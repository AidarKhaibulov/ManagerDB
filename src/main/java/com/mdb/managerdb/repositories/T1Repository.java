package com.mdb.managerdb.repositories;

import com.mdb.managerdb.entities.entitiesFor4Task.Employee1NF;
import com.mdb.managerdb.entities.entitiesFor5Task.T1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface T1Repository extends JpaRepository<T1, Long> {
    @Query("SELECT e FROM T1 e ORDER BY e.id")
    List<T1> findFirstNEmployees(int n);
}
