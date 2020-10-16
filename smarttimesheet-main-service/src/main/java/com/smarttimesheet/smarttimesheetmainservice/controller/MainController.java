package com.smarttimesheet.smarttimesheetmainservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MainController {
    @GetMapping("/hello")
    public ResponseEntity<String> getMessage() {
        return ResponseEntity.ok("Hello world");
    }
}
