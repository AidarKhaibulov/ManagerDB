package com.mdb.managerdb.repositories;


import com.mdb.managerdb.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
