package com.ktmon.trackerbatch.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@CrossOrigin(value = "*")
@RestController
@RequestMapping("/oauth")
public class TestController {

    @GetMapping
    public ResponseEntity login(String s) {
        log.info(s);
        return ResponseEntity.ok(s);
    }
}
