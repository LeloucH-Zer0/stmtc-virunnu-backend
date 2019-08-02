package com.stmtcmarathahalli.virunnu.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.stmtcmarathahalli.virunnu.models.FoodModel;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FoodDto extends FoodModel {

}
