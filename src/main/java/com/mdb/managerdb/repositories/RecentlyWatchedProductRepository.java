package com.mdb.managerdb.repositories;


import com.mdb.managerdb.entities.RecentlyWatchedProduct;
import com.mdb.managerdb.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecentlyWatchedProductRepository extends JpaRepository<RecentlyWatchedProduct,Long> {
    RecentlyWatchedProduct findByUser(UserEntity user);

}
