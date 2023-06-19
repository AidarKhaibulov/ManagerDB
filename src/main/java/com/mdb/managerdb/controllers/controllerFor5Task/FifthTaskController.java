package com.mdb.managerdb.controllers.controllerFor5Task;

import com.mdb.managerdb.entities.entitiesFor5Task.*;
import com.mdb.managerdb.repositories.*;
import com.mdb.managerdb.services.ChartBuilder;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.SecureRandom;

import java.util.TreeMap;

@RestController
@RequestMapping("/task5")
@RequiredArgsConstructor
@Slf4j
public class FifthTaskController {
    private final T1Repository t1Repository;
    private final T2Repository t2Repository;
    private final T3Repository t3Repository;
    private final T4Repository t4Repository;
    private final ChartBuilder chartBuilder;
    private final int rowsAmount=2000;
    private final SecureRandom random = new SecureRandom();
    @PersistenceContext
    private EntityManager entityManager;
    @GetMapping("/a1")
    public ResponseEntity<String> a1() {
        perform1partOfTask("T1","T2","a1.png");

        return ResponseEntity.ok("Created");

    }

    @GetMapping("/a2")
    public ResponseEntity<String> a2() {
        TreeMap<Integer, Long> data1 = new TreeMap<>();
        TreeMap<Integer, Long> data2 = new TreeMap<>();

        long totalTime1 = 0;
        long totalTime2 = 0;
        for (int rowCount = 100; rowCount <= rowsAmount; rowCount += 100) {
            long startTime1 = System.currentTimeMillis();
            generateT2(rowCount-100,rowCount);
            long endTime1 = System.currentTimeMillis();
            long executionTime1 = endTime1 - startTime1;
            totalTime1 += executionTime1;
            data1.put(rowCount, totalTime1);

            long startTime2 = System.currentTimeMillis();
            generateT1();
            long endTime2 = System.currentTimeMillis();
            long executionTime2 = endTime2 - startTime2;
            totalTime2 += executionTime2;
            data2.put(rowCount, totalTime2);
        }

        DefaultCategoryDataset dataset = chartBuilder.createDoubleData(data1,data2,"T1","T2");
        JFreeChart chart= chartBuilder.createPlot(dataset,"a2","Number of Rows");

        chartBuilder.savePlot(chart,"a2.png");

        return ResponseEntity.ok("Created");

    }
    @GetMapping("/b1")
    public ResponseEntity<String> b1() {
        perform1partOfTask("T3","T4","b1.png");

        return ResponseEntity.ok("Created");

    }

    private void perform1partOfTask(String table1,String table2,String fileName) {
        TreeMap<Integer, Long> data1 = new TreeMap<>();
        TreeMap<Integer, Long> data2 = new TreeMap<>();

        long totalTime1 = 0;
        long totalTime2 = 0;
        for (int rowCount = 100; rowCount <= rowsAmount; rowCount += 100) {
            long startTime1 = System.currentTimeMillis();
            findAll(table1,rowCount);
            long endTime1 = System.currentTimeMillis();
            long executionTime1 = endTime1 - startTime1;
            totalTime1 += executionTime1;
            data1.put(rowCount, totalTime1);

            long startTime2 = System.currentTimeMillis();
            findAll(table2,rowCount);
            long endTime2 = System.currentTimeMillis();
            long executionTime2 = endTime2 - startTime2;
            totalTime2 += executionTime2;
            data2.put(rowCount, totalTime2);
            System.out.println(rowCount);
            System.out.println(data1);
        }

        DefaultCategoryDataset dataset = chartBuilder.createDoubleData(data1,data2,table1,table2);
        JFreeChart chart= chartBuilder.createPlot(dataset,fileName.substring(0,3),"Number of Rows");

        chartBuilder.savePlot(chart,fileName);
    }

    @GetMapping("/b2")
    public ResponseEntity<String > b2() {
        TreeMap<Integer, Long> data1 = new TreeMap<>();
        TreeMap<Integer, Long> data2 = new TreeMap<>();

        long totalTime1 = 0;
        long totalTime2 = 0;
        for (int rowCount = 100; rowCount <= rowsAmount; rowCount += 100) {
            long startTime1 = System.currentTimeMillis();
            generateT3(rowCount-100,rowCount);
            long endTime1 = System.currentTimeMillis();
            long executionTime1 = endTime1 - startTime1;
            totalTime1 += executionTime1;
            data1.put(rowCount, totalTime1);

            long startTime2 = System.currentTimeMillis();
            generateT4();
            long endTime2 = System.currentTimeMillis();
            long executionTime2 = endTime2 - startTime2;
            totalTime2 += executionTime2;
            data2.put(rowCount, totalTime2);
        }

        DefaultCategoryDataset dataset = chartBuilder.createDoubleData(data1,data2,"T3","T4");
        JFreeChart chart= chartBuilder.createPlot(dataset,"b2","Number of Rows");

        chartBuilder.savePlot(chart,"b2.png");

        return ResponseEntity.ok("Created");

    }
    public void findAll(String table,int count) {
        switch (table){
            case "T1"->
                t1Repository.findFirstNEmployees(count);
            case "T2"->
                    t2Repository.findFirstNEmployees(count);
            case "T3"->
                    t3Repository.findFirstNEmployees(count);
            case "T4"->
                    t4Repository.findFirstNEmployees(count);
        }


    }
    private void generateT1(){
        for (int i = 0; i < 100; i++) {
            T1 t1 = T1.builder()
                    .value(String.valueOf(i)).build();
            t1Repository.save(t1);
        }
    }

    private void generateT2(int i, int rowCount){
        for (; i < rowCount; i++) {
            T2 t2 = T2.builder().value(new T2Id(String.valueOf(i))).build();
            t2Repository.save(t2);
        }
    }
    private void generateT3(int i, int rowCount){
        for (; i < rowCount; i++) {
            T3 t3 = T3.builder().index(String.valueOf(i)).data(String.valueOf(i)).build();
            t3Repository.save(t3);
        }
    }

    private void generateT4(){
        for (int i = 0; i < 100; i++) {
            T4 t4 = T4.builder()
                    .data(String.valueOf(random.nextDouble())).build();
            t4Repository.save(t4);
        }
    }
}
