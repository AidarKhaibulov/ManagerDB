package com.mdb.managerdb.controllers;

import com.mdb.managerdb.services.ChartBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/queries")
@RequiredArgsConstructor
@Slf4j
public class QueryRunnerController {
    private final JdbcTemplate jdbcTemplate;
    private final ChartBuilder chartBuilder;

    @PostMapping(value = "/executeQuery", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> executeQueryAndMeasureTime(@RequestBody String query) {
        long startTime = System.currentTimeMillis();

        try {
            jdbcTemplate.execute(query);
            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;

            return ResponseEntity.ok("Время выполнения запроса: " + executionTime + "ms");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ошибка во время выполнения запроса " + e.getMessage());
        }
    }


    @GetMapping(value = "/query-execute-plot/{queryType}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Long>> createQueryExecutePlotForInsert(@RequestBody String className, @PathVariable String queryType) {
        switch (className) {
            case "user" -> {
                Map<String, Long> data = chartBuilder.createRawQueryData("users",queryType);
                createPlot(data,queryType);
                return ResponseEntity.ok(data);
            }
            case "product" -> {
                Map<String, Long> data = chartBuilder.createRawQueryData("products",queryType);
                createPlot(data,queryType);
                return ResponseEntity.ok(data);
            }
            case "category" -> {
                Map<String, Long> data = chartBuilder.createRawQueryData("categories",queryType);
                createPlot(data,queryType);
                return ResponseEntity.ok(data);
            }
            case "cart" -> {
                Map<String, Long> data = chartBuilder.createRawQueryData("carts",queryType);
                createPlot(data,queryType);
                return ResponseEntity.ok(data);
            }
            case "recentlyWatchedProduct" -> {
                Map<String, Long> data = chartBuilder.createRawQueryData("recently_watched_products",queryType);
                createPlot(data,queryType);
                return ResponseEntity.ok(data);
            }
            default -> throw new RuntimeException("Invalid class");
        }
    }

    private void createPlot(Map<String, Long> data,String queryType) {
        DefaultCategoryDataset dataset = chartBuilder.createDataForPlot(data);
        JFreeChart plot = chartBuilder.createPlot(dataset);
        chartBuilder.savePlot(plot, queryType+".png");
    }
}
