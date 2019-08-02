package com.stmtcmarathahalli.virunnu.mappers;

import com.stmtcmarathahalli.virunnu.dtos.FoodDto;
import com.stmtcmarathahalli.virunnu.entities.FoodEntity;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodMapper {
  
  FoodMapper INSTANCE = Mappers.getMapper(FoodMapper.class);
  
  FoodDto convertFoodEntityToDto(FoodEntity entity);
  
  List<FoodDto> convertFoodEntityToDto(List<FoodEntity> entity);

}
