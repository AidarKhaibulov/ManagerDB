package com.mdb.managerdb.controllers;

import com.mdb.managerdb.services.ChartBuilder;
import com.mdb.managerdb.entities.Product;
import com.mdb.managerdb.entities.UserEntity;
import com.mdb.managerdb.services.AutoDataGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/generate")
@RequiredArgsConstructor
@Slf4j
public class GenerateController {
    private final AutoDataGenerator autoDataGenerator;
    private final ChartBuilder chartBuilder;

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
    @GetMapping("/data-generation-plot")
    public ResponseEntity<Map<String, Long>> generateData() {
        Map<String, Long> data = chartBuilder.createRawData();

        DefaultCategoryDataset dataset = chartBuilder.createDataForPlot(data);
        JFreeChart plot = chartBuilder.createPlot(dataset);
        chartBuilder.savePlot(plot,"data_generation_chart.png");

        return ResponseEntity.ok(data);
    }



}
