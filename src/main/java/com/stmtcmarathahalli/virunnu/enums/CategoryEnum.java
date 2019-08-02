package com.stmtcmarathahalli.virunnu.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum CategoryEnum {

  SNACKS(1, "Snacks"), STARTERS(2, "Starters"), MAIN_COURSE(3, "Main Course"), DESSERTS(4,
      "Desserts"), DRINKS(5, "Drinks");

  Integer id;

  String name;

  private CategoryEnum(Integer id, String name) {
    this.id = id;
    this.name = name;
  }

  private static final Map<Integer, CategoryEnum> reverseMap;

  static {
    reverseMap = Arrays.stream(CategoryEnum.values())
        .collect(Collectors.toMap(CategoryEnum::getId, Function.identity()));
  }

  public final Integer getId() {
    return id;
  }

  public final String getName() {
    return name;
  }

  public static CategoryEnum getEnumById(Integer id) {
    return reverseMap.get(id);
  }

}
