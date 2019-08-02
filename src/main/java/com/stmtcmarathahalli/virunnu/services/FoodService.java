package com.stmtcmarathahalli.virunnu.services;

import com.stmtcmarathahalli.virunnu.daos.FoodDao;
import com.stmtcmarathahalli.virunnu.dtos.CategoryItemsDto;
import com.stmtcmarathahalli.virunnu.dtos.FoodDto;
import com.stmtcmarathahalli.virunnu.entities.FoodEntity;
import com.stmtcmarathahalli.virunnu.enums.CategoryEnum;
import com.stmtcmarathahalli.virunnu.mappers.FoodMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class FoodService {

  private FoodDao foodDao;

  public FoodService(FoodDao foodDao) {
    super();
    this.foodDao = foodDao;
  }

  public List<CategoryItemsDto> getListOfFood() {
    List<FoodEntity> foodList = foodDao.findByStatus(true);
    List<FoodDto> foodDtoList = FoodMapper.INSTANCE.convertFoodEntityToDto(foodList);
    Map<Integer, List<FoodDto>> categoryMap =
        foodDtoList.stream().collect(Collectors.groupingBy(FoodDto::getType));
    List<CategoryItemsDto> itemsDtoList = new ArrayList<>();
    for (Map.Entry<Integer, List<FoodDto>> entry : categoryMap.entrySet()) {
      CategoryItemsDto dto = new CategoryItemsDto();
      dto.setCategoryName(CategoryEnum.getEnumById(entry.getKey()).getName());
      dto.setItems(entry.getValue());
      itemsDtoList.add(dto);
    }
    return itemsDtoList;
  }

  public Map<Integer, Integer> getCountOfFood() {
    List<FoodEntity> foodList = foodDao.findByStatus(true);
    List<FoodDto> foodDtoList = FoodMapper.INSTANCE.convertFoodEntityToDto(foodList);
    return foodDtoList.stream().collect(Collectors.toMap(FoodDto::getId, FoodDto::getCount));
  }

  public Boolean sellFood(FoodDto dto) {
    synchronized (this) {
      FoodEntity entity = foodDao.findOne(dto.getId());
      if(entity.getCount() - dto.getCount() < 0) {
        return false;
      }
      entity.setCount(entity.getCount() - dto.getCount());
      foodDao.save(entity);
    }
    return true;
    
  }

}
