package com.mdb.managerdb.repositories;


import com.mdb.managerdb.entities.Cart;
import com.mdb.managerdb.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {
    Cart findByUser(UserEntity user);
}
