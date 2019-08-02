package com.stmtcmarathahalli.virunnu.daos;

import com.stmtcmarathahalli.virunnu.entities.FoodEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodDao extends JpaRepository<FoodEntity, Integer> {
  
  List<FoodEntity> findByStatus(Boolean status);

}
