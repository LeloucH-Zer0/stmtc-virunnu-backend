package com.stmtcmarathahalli.virunnu.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
public class StatusController {
  
  @GetMapping("/")
  public ResponseEntity<Map<String, String>> status() {
    Map<String, String> map = new HashMap<>();
    map.put("status", "OK");
    return new ResponseEntity<>(map, HttpStatus.OK);
  }

}
