package com.mdb.managerdb.repositories;

import com.mdb.managerdb.entities.entitiesFor5Task.T1;
import com.mdb.managerdb.entities.entitiesFor5Task.T2;
import com.mdb.managerdb.entities.entitiesFor5Task.T2Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface T2Repository extends JpaRepository<T2, T2Id> {
    @Query("SELECT e FROM T2 e")
    List<T2> findFirstNEmployees(int n);
}
