package com.mdb.managerdb.repositories;


import com.mdb.managerdb.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findByEmail(String email);
    UserEntity findByUsername(String username);
    UserEntity findFirstByUsername(String username);

}
