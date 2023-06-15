package com.mdb.managerdb.controllers;

import com.mdb.managerdb.services.DatabaseBackupManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/backup")
@RequiredArgsConstructor
@Slf4j
public class BackupController {
    private final DatabaseBackupManager databaseCopier;
    @PostMapping("/copyDB")
    public ResponseEntity<String> copyDB() {
        databaseCopier.copyDB();
        return ResponseEntity.ok("Copied!");
    }
    @PostMapping("/restoreDB/{scriptPath}")
    public ResponseEntity<String> restoreDB(@PathVariable String scriptPath) {
        databaseCopier.restoreDB(scriptPath);
        return ResponseEntity.ok("Restored!");
    }
}
