package com.mdb.managerdb.repositories;

import com.mdb.managerdb.entities.entitiesFor5Task.T2;
import com.mdb.managerdb.entities.entitiesFor5Task.T2Id;
import com.mdb.managerdb.entities.entitiesFor5Task.T3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface T3Repository extends JpaRepository<T3, String > {
    @Query("SELECT e FROM T3 e")
    List<T3> findFirstNEmployees(int n);
}
