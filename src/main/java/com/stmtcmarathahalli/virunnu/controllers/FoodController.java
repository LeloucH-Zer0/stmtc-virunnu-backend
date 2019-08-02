package com.stmtcmarathahalli.virunnu.controllers;

import com.stmtcmarathahalli.virunnu.dtos.CategoryItemsDto;
import com.stmtcmarathahalli.virunnu.dtos.FoodDto;
import com.stmtcmarathahalli.virunnu.services.FoodService;

import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/food")
public class FoodController {

  private static final Logger LOGGER = LoggerFactory.getLogger(FoodController.class);
  private FoodService foodService;

  public FoodController(FoodService foodDao) {
    super();
    this.foodService = foodDao;
  }

  @PostMapping("/{id}")
  public ResponseEntity<?> initializeNumberOfFood(@PathParam("id") Integer id,
      @RequestBody FoodDto initializeFoodRequest) {
    return null;
  }

  @GetMapping("/")
  public ResponseEntity<List<CategoryItemsDto>> getListOfFood() {
    return new ResponseEntity<>(foodService.getListOfFood(), HttpStatus.OK);
  }

  @GetMapping("/count")
  public ResponseEntity<Map<Integer, Integer>> getCountOfItems() {
    return new ResponseEntity<>(foodService.getCountOfFood(), HttpStatus.OK);
  }

  @PatchMapping("/{id}")
  public ResponseEntity<Boolean> sellItem(@PathVariable("id") Integer id, @RequestBody FoodDto dto) {
    LOGGER.info("Id : {}", id);
    dto.setId(id);
    return new ResponseEntity<>(foodService.sellFood(dto), HttpStatus.OK);
  }



}
