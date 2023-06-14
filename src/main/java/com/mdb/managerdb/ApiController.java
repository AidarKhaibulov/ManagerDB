package com.mdb.managerdb;

import com.mdb.managerdb.entities.Product;
import com.mdb.managerdb.entities.UserEntity;
import com.mdb.managerdb.services.AutoDataGenerator;
import com.mdb.managerdb.services.DatabaseCopier;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/generate")
@RequiredArgsConstructor
@Slf4j
public class ApiController {
    private final AutoDataGenerator autoDataGenerator;
    private final DatabaseCopier databaseCopier;
    @PostMapping("/product")
    public ResponseEntity<Product> generateProduct() {
        return ResponseEntity.ok(autoDataGenerator.generateData(Product.class));
    }
    @PostMapping("/product/{numberOfRows}")
    public ResponseEntity<List<Product>> generateManyProducts(@PathVariable int numberOfRows) {
        return ResponseEntity.ok(autoDataGenerator.generateMultipleData(Product.class,numberOfRows));
    }
    @PostMapping("/user")
    public ResponseEntity<UserEntity> generateUser() {
        return ResponseEntity.ok(autoDataGenerator.generateData(UserEntity.class));
    }
    @PostMapping("/user/{numberOfRows}")
    public ResponseEntity<List<UserEntity>> generateManyUsers(@PathVariable int numberOfRows) {
        return ResponseEntity.ok(autoDataGenerator.generateMultipleData(UserEntity.class,numberOfRows));
    }
    @PostMapping("/copyDB")
    public ResponseEntity<String> copyDB() {
        databaseCopier.copyDB();
        return ResponseEntity.ok("Copied!");
    }
}
