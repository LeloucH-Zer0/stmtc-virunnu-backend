package com.stmtcmarathahalli.virunnu.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CategoryItemsDto {
  
  private List<FoodDto> items;
  
  private String categoryName;

  public final List<FoodDto> getItems() {
    return items;
  }

  public final void setItems(List<FoodDto> items) {
    this.items = items;
  }

  @JsonProperty("category_name")
  public final String getCategoryName() {
    return categoryName;
  }

  public final void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }
  
}
