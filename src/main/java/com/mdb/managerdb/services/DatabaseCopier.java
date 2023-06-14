package com.mdb.managerdb.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public class DatabaseCopier {
    String host = "localhost";
    String port = "5432";

    String database = "agregator";
    @Value("${PDB_USERNAME}")
    String username;
    @Value("${PDB_PASSWORD}")
    String password ;
    String dumpFilePath = "dump.sql";
    public void copyDB(){


        try {
            ProcessBuilder processBuilder = new ProcessBuilder(
                    "pg_dump",
                    "-h", host,
                    "-p", port,
                    "-U", username,
                    "-F", "p",
                    "-b",
                    "-v",
                    "-f", dumpFilePath,
                    database
            );

            processBuilder.environment().put("PGPASSWORD", password);
            Process process = processBuilder.start();

            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("Дамп базы данных успешно создан.");
            } else {
                System.err.println("Ошибка при создании дампа базы данных.");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
