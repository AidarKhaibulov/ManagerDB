package com.mdb.managerdb.services;

import com.mdb.managerdb.entities.*;
import lombok.RequiredArgsConstructor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@Service
@RequiredArgsConstructor
public class ChartBuilder {
    private final AutoDataGenerator autoDataGenerator;
    private final JdbcTemplate jdbcTemplate;

    private final AutoDataGenerator dataGenerator;

    public void savePlot(JFreeChart plot, String fileName) {
        try {
            ChartUtils.saveChartAsPNG(new File(fileName), plot, 1920, 1080);
            System.out.println("График сохранен в файле");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public JFreeChart createPlot(DefaultCategoryDataset dataset,String title,String X) {
        JFreeChart plot = ChartFactory.createLineChart(
                title,
                X,
                "Time (ms)",
                dataset
        );
        return plot;
    }

    public DefaultCategoryDataset createDataForPlot(TreeMap<Integer, Long> data) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Map.Entry<Integer, Long> entry : data.entrySet()) {
            Integer xValue = entry.getKey();
            Long yValue = entry.getValue();
            dataset.addValue(yValue, "Time", xValue);
        }
        return dataset;
    }

    public DefaultCategoryDataset createDoubleData(TreeMap<Integer, Long> data1, TreeMap<Integer, Long> data2, String t1, String t2) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Map.Entry<Integer, Long> entry : data1.entrySet()) {
            dataset.addValue(entry.getValue(), t1, entry.getKey());
        }

        for (Map.Entry<Integer, Long> entry : data2.entrySet()) {
            dataset.addValue(entry.getValue(), t2, entry.getKey());
        }
        return dataset;
    }

    public TreeMap<Integer, Long> createRawData() {
        TreeMap<Integer, Long> data = new TreeMap<>();
        long totalTime = 0;
        for (int rowCount = 100; rowCount <= 1000; rowCount += 100) {
            long startTime = System.currentTimeMillis();
            autoDataGenerator.generateMultipleData(UserEntity.class, 100);
            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;
            totalTime += executionTime;
            data.put(rowCount, totalTime);
        }
        return data;
    }

    public TreeMap<Integer, Long> createRawQueryData(String tableName, String queryType) {
        TreeMap<Integer, Long> timings = new TreeMap<>();
        long totalTime = 0;
        String sql = "";
        for (int rowCount = 100; rowCount <= 1000; rowCount += 100) {
            long startTime = 0;
            switch (queryType) {
                case "select" -> {
                    sql = "SELECT * FROM " + tableName + " LIMIT " + rowCount;
                    startTime = System.nanoTime();
                    jdbcTemplate.queryForList(sql);
                    long endTime = System.nanoTime();
                    long executionTime = endTime - startTime;
                    totalTime += executionTime;
                    timings.put(rowCount, totalTime);
                }
                case "insert" -> {
                    startTime = System.nanoTime();
                    switch (tableName) {
                        case "users" -> dataGenerator.generateMultipleData(UserEntity.class, 100);
                        case "products" -> dataGenerator.generateMultipleData(Product.class, 100);
                        case "category" -> dataGenerator.generateMultipleData(Category.class, 100);
                        case "cart" -> dataGenerator.generateMultipleData(Cart.class, 100);
                        case "recentlyWatchedProduct" ->
                                dataGenerator.generateMultipleData(RecentlyWatchedProduct.class, 100);
                    }
                    long endTime = System.nanoTime();
                    long executionTime = endTime - startTime;
                    totalTime += executionTime;
                    timings.put(rowCount, totalTime);
                }
                case "delete" -> {
                    startTime = System.nanoTime();
                    jdbcTemplate.execute(sql);
                    sql = "DELETE FROM " + tableName + " WHERE id IN ( SELECT id FROM " + tableName + " ORDER BY id LIMIT " + rowCount + ");";
                    long endTime = System.nanoTime();
                    long executionTime = endTime - startTime;
                    totalTime += executionTime;
                    timings.put(rowCount, totalTime);
                }
            }
        }
        return timings;
    }
}
