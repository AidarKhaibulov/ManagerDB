package com.mdb.managerdb.controllers;

import com.mdb.managerdb.entities.Product;
import com.mdb.managerdb.entities.UserEntity;
import com.mdb.managerdb.services.DatabaseDataManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/manage")
@RequiredArgsConstructor
@Slf4j
public class DataManagerController {
    private final DatabaseDataManager dataManager;
    @PostMapping("/product")
    public ResponseEntity<String > deleteProduct() {
        dataManager.deleteTable(Product.class);
        return ResponseEntity.ok("Product table cleared!");
    }
    @PostMapping("/user")
    public ResponseEntity<String> deleteUser() {
        dataManager.deleteTable(UserEntity.class);
        return ResponseEntity.ok("User table cleared!");
    }

    @PostMapping("/replaceProduct")
    public ResponseEntity<String> replaceProduct(@RequestBody List<Product> products) {
        dataManager.replaceDataInTable(Product.class, products);
        return ResponseEntity.ok("Product table data replaced!");
    }

    @PostMapping("/replaceUser")
    public ResponseEntity<String> replaceUser(@RequestBody List<UserEntity> users) {
        dataManager.replaceDataInTable(UserEntity.class, users);
        return ResponseEntity.ok("User table data replaced!");
    }

}
