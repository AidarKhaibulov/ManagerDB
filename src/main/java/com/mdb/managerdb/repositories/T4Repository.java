package com.mdb.managerdb.repositories;

import com.mdb.managerdb.entities.entitiesFor5Task.T2;
import com.mdb.managerdb.entities.entitiesFor5Task.T4;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface T4Repository extends JpaRepository<T4, Long > {
    @Query("SELECT e FROM T4 e")
    List<T4> findFirstNEmployees(int n);
}
