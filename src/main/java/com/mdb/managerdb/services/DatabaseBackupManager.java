package com.mdb.managerdb.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DatabaseBackupManager {
    String host = "localhost";
    String port = "5432";

    String database = "aidar";
    @Value("${PDB_USERNAME:aidar}")
    String username;
    @Value("${PDB_PASSWORD:sitis}")
    String password;
    String dumpFilePath = "dump.sql";

    public void copyDB() {
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
                System.out.println("Дамп базы данных успешно создан");
            } else {
                System.err.println("Ошибка при создании дампа базы данных!");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void sandbox() {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(
                    "pg_dump",
                    "-h", host,
                    "-p", port,
                    "-U", username,
                    "-F", "p",
                    "-s",
                    "-v",
                    "-f", "sandbox.sql",
                    database
            );

            processBuilder.environment().put("PGPASSWORD", password);
            Process process = processBuilder.start();

            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("Песочница базы данных успешно создан");
            } else {
                System.err.println("Ошибка при создании песочницы базы данных!");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void restoreDB(String dumpFilePath) {

        try {
            ProcessBuilder processBuilder = new ProcessBuilder(
                    "psql",
                    "-U", username,
                    "-f", dumpFilePath
            );

            processBuilder.environment().put("PGPASSWORD", password);
            Process process = processBuilder.start();

            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("База данных успешно восстановлена из скрипта.");
            } else {
                System.err.println("Ошибка при восстановлении базы данных из скрипта.");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
