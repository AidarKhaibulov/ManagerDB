package com.mdb.managerdb.controllers.controllerFor4Task;

import com.mdb.managerdb.controllers.controllerFor5Task.FifthTaskController;
import com.mdb.managerdb.entities.entitiesFor4Task.Employee1NF;
import com.mdb.managerdb.entities.entitiesFor4Task.NF2.Employee2NF;
import com.mdb.managerdb.entities.entitiesFor4Task.NF3.Employee3NF;
import com.mdb.managerdb.entities.entitiesFor4Task.NF4.Employee4NF;
import com.mdb.managerdb.entities.entitiesFor4Task.NF5.Employee5NF;
import com.mdb.managerdb.repositories.*;
import com.mdb.managerdb.services.ChartBuilder;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

@RestController
@RequestMapping("/task4")
@RequiredArgsConstructor
@Slf4j
public class FourthTaskController {
    public enum State {
        NF_1,
        NF_2,
        NF_3,
        NF_4,
        NF_5
    }

    @PersistenceContext
    private EntityManager entityManager;
    private final ChartBuilder chartBuilder;
    private final int rowsAmount = 2000;
    @Autowired
    private final E1Repository e1Repository;
    @Autowired
    private final E2Repository e2Repository;
    @Autowired
    private final E3Repository e3Repository;
    @Autowired
    private final E4Repository e4Repository;
    @Autowired
    private final E5Repository e5Repository;
    private final FifthTaskController fifthTaskController;
    private final JdbcTemplate jdbcTemplate;

    @GetMapping("/bInsert")
    public ResponseEntity<String> bInsert() {
        TreeMap<Integer, Long> data1 = getDatasetForInsert(State.NF_1);
        TreeMap<Integer, Long> data2 = getDatasetForInsert(State.NF_2);
        TreeMap<Integer, Long> data3 = getDatasetForInsert(State.NF_3);
        TreeMap<Integer, Long> data4 = getDatasetForInsert(State.NF_4);
        TreeMap<Integer, Long> data5 = getDatasetForInsert(State.NF_5);

        DefaultCategoryDataset dataset = getDataset(data1, data2, data3, data4, data5);

        JFreeChart chart = ChartFactory.createLineChart(
                "4b Insert",
                "Row Count",
                "Execution Time (ms)",
                dataset
        );
        try {
            ChartUtils.saveChartAsPNG(new File("4_task_Insert.png"), chart, 1920, 1080);
            System.out.println("График сохранен в файле");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok("Created");
    }

    @GetMapping("/bSelect")
    public ResponseEntity<String> bSelect() {
        TreeMap<Integer, Long> data1 = getDatasetForSelect(State.NF_1);
        TreeMap<Integer, Long> data2 = getDatasetForSelect(State.NF_2);
        TreeMap<Integer, Long> data3 = getDatasetForSelect(State.NF_3);
        TreeMap<Integer, Long> data4 = getDatasetForSelect(State.NF_4);
        TreeMap<Integer, Long> data5 = getDatasetForSelect(State.NF_5);

        DefaultCategoryDataset dataset = getDataset(data1, data2, data3, data4, data5);

        JFreeChart chart = ChartFactory.createLineChart(
                "4b Select",
                "Row Count",
                "Execution Time (ms)",
                dataset
        );
        try {
            ChartUtils.saveChartAsPNG(new File("4_task_select.png"), chart, 1920, 1080);
            System.out.println("График сохранен в файле");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok("Created");
    }

    @GetMapping("/c")
    public ResponseEntity<String> c() {
        String sql = "SELECT pg_total_relation_size('employees_1nf')";
        long v1 = jdbcTemplate.queryForObject(sql, Long.class);

        sql = "SELECT pg_total_relation_size('employees_2nf')";
        long v2 = jdbcTemplate.queryForObject(sql, Long.class);
        sql = "SELECT pg_total_relation_size('employees_details_2nf')";
        v2+=jdbcTemplate.queryForObject(sql, Long.class);

        sql = "SELECT pg_total_relation_size('employees_3nf')";
        long v3 = jdbcTemplate.queryForObject(sql, Long.class);
        sql = "SELECT pg_total_relation_size('employee_details_3nf')";
        v3+=jdbcTemplate.queryForObject(sql, Long.class);
        sql = "SELECT pg_total_relation_size('positions3nf')";
        v3+=jdbcTemplate.queryForObject(sql, Long.class);

        sql = "SELECT pg_total_relation_size('employees_4nf')";
        long v4 = jdbcTemplate.queryForObject(sql, Long.class);
        sql = "SELECT pg_total_relation_size('employee_details_4nf')";
        v4+=jdbcTemplate.queryForObject(sql, Long.class);
        sql = "SELECT pg_total_relation_size('positions4nf')";
        v4+=jdbcTemplate.queryForObject(sql, Long.class);
        sql = "SELECT pg_total_relation_size('employee_salaries_4nf')";
        v4+=jdbcTemplate.queryForObject(sql, Long.class);

        sql = "SELECT pg_total_relation_size('employees_5nf')";
        long v5 = jdbcTemplate.queryForObject(sql, Long.class);
        sql = "SELECT pg_total_relation_size('employee_details_5nf')";
        v5+=jdbcTemplate.queryForObject(sql, Long.class);
        sql = "SELECT pg_total_relation_size('positions4nf')";
        v5+=jdbcTemplate.queryForObject(sql, Long.class);
        sql = "SELECT pg_total_relation_size('employee_salaries_5nf')";
        v5+=jdbcTemplate.queryForObject(sql, Long.class);

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(v1, "Table 1", "");
        dataset.addValue(v2, "Table 2", "");
        dataset.addValue(v3, "Table 3", "");
        dataset.addValue(v4, "Table 4", "");
        dataset.addValue(v5, "Table 5", "");

        // Создание графика
        JFreeChart chart = ChartFactory.createBarChart(
                "Размеры таблиц",  // Заголовок графика
                "",                // Метка оси X
                "Размер",          // Метка оси Y
                dataset,           // Данные для графика
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        // Сохранение графика в файл
        try {
            ChartUtils.saveChartAsPNG(new File("tableSizes.png"), chart, 800, 600);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok("Created");
    }

    private static DefaultCategoryDataset getDataset(TreeMap<Integer, Long> data1, TreeMap<Integer, Long> data2, TreeMap<Integer, Long> data3, TreeMap<Integer, Long> data4, TreeMap<Integer, Long> data5) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Map.Entry<Integer, Long> entry : data1.entrySet()) {
            dataset.addValue(entry.getValue(), "NF_1", entry.getKey());
        }

        for (Map.Entry<Integer, Long> entry : data2.entrySet()) {
            dataset.addValue(entry.getValue(), "NF_2", entry.getKey());
        }

        for (Map.Entry<Integer, Long> entry : data3.entrySet()) {
            dataset.addValue(entry.getValue(), "NF_3", entry.getKey());
        }

        for (Map.Entry<Integer, Long> entry : data4.entrySet()) {
            dataset.addValue(entry.getValue(), "NF_4", entry.getKey());
        }

        for (Map.Entry<Integer, Long> entry : data5.entrySet()) {
            dataset.addValue(entry.getValue(), "NF_5", entry.getKey());
        }
        return dataset;
    }

    public TreeMap<Integer, Long> getDatasetForInsert(State state) {
        Random random = new Random();
        TreeMap<Integer, Long> data = new TreeMap<>();

        switch (state) {
            case NF_1:
                long totalTime = 0;
                for (int rowCount = 0; rowCount <= rowsAmount; rowCount += 1) {
                    Employee1NF employee = Employee1NF.builder()
                            .firstName(generateRandomString(10))
                            .lastName(generateRandomString(10))
                            .department(generateRandomString(10))
                            .position(generateRandomString(10))
                            .salary(BigDecimal.valueOf(random.nextInt(10000)))
                            .hireDate(new Date())
                            .address(generateRandomString(10))
                            .phone(generateRandomString(10)).build();
                    long startTime = System.currentTimeMillis();

                    e1Repository.save(employee);

                    long endTime = System.currentTimeMillis();
                    long executionTime = endTime - startTime;
                    totalTime += executionTime;
                    if (rowCount % 100 == 0)
                        data.put(rowCount, totalTime);

                }
                break;
            case NF_2:
                totalTime = 0;
                for (int rowCount = 0; rowCount <= rowsAmount; rowCount++) {
                    Employee2NF employee = Employee2NF.builder()
                            .firstName(generateRandomString(10))
                            .lastName(generateRandomString(10))
                            .address(generateRandomString(10))
                            .phone(generateRandomString(10)).build();
                    long startTime = System.currentTimeMillis();

                    e2Repository.save(employee);


                    long endTime = System.currentTimeMillis();
                    long executionTime = endTime - startTime;
                    totalTime += executionTime;
                    if (rowCount % 100 == 0)
                        data.put(rowCount, totalTime);

                }
                break;
            case NF_3:
                totalTime = 0;
                for (int rowCount = 0; rowCount <= rowsAmount; rowCount++) {
                    Employee3NF employee = Employee3NF.builder()
                            .firstName(generateRandomString(10))
                            .lastName(generateRandomString(10))
                            .address(generateRandomString(10))
                            .phone(generateRandomString(10)).build();
                    long startTime = System.currentTimeMillis();

                    e3Repository.save(employee);


                    long endTime = System.currentTimeMillis();
                    long executionTime = endTime - startTime;
                    totalTime += executionTime;
                    if (rowCount % 100 == 0)
                        data.put(rowCount, totalTime);

                }
                break;
            case NF_4:
                totalTime = 0;
                for (int rowCount = 0; rowCount <= rowsAmount; rowCount++) {
                    Employee4NF employee = Employee4NF.builder()
                            .firstName(generateRandomString(10))
                            .lastName(generateRandomString(10))
                            .phone(generateRandomString(10)).build();
                    long startTime = System.currentTimeMillis();

                    e4Repository.save(employee);


                    long endTime = System.currentTimeMillis();
                    long executionTime = endTime - startTime;
                    totalTime += executionTime;
                    if (rowCount % 100 == 0)
                        data.put(rowCount, totalTime);

                }
                break;
            case NF_5:
                totalTime = 0;
                for (int rowCount = 0; rowCount <= rowsAmount; rowCount++) {
                    Employee5NF employee = Employee5NF.builder()
                            .firstName(generateRandomString(10))
                            .lastName(generateRandomString(10))
                            .phone(generateRandomString(10)).build();
                    long startTime = System.currentTimeMillis();

                    e5Repository.save(employee);


                    long endTime = System.currentTimeMillis();
                    long executionTime = endTime - startTime;
                    totalTime += executionTime;
                    if (rowCount % 100 == 0)
                        data.put(rowCount, totalTime);
                }
                break;
            default:
                System.out.println("Unknown state");
                break;
        }
        return data;
    }

    public TreeMap<Integer, Long> getDatasetForSelect(State state) {
        TreeMap<Integer, Long> data = new TreeMap<>();
        long totalTime = 0;
        for (int rowCount = 0; rowCount <= rowsAmount; rowCount++) {
            long startTime = System.currentTimeMillis();
            if (rowCount % 100 == 0) {
                switch (state) {
                    case NF_1:
                        e1Repository.findFirstNEmployees(rowCount);
                        break;
                    case NF_2:
                        e2Repository.findFirstNEmployees(rowCount);
                        break;
                    case NF_3:
                        e3Repository.findFirstNEmployees(rowCount);
                        break;
                    case NF_4:
                        e4Repository.findFirstNEmployees(rowCount);
                        break;
                    case NF_5:
                        e5Repository.findFirstNEmployees(rowCount);
                        break;
                    default:
                        System.out.println("Unknown state");
                        break;
                }

                long endTime = System.currentTimeMillis();
                long executionTime = endTime - startTime;
                totalTime += executionTime;

                data.put(rowCount, totalTime);
            }
        }
        return data;
    }

    private String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder stringBuilder = new StringBuilder(length);

        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            char randomChar = characters.charAt(index);
            stringBuilder.append(randomChar);
        }

        return stringBuilder.toString();
    }
}
