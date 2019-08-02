package com.stmtcmarathahalli.virunnu.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@JsonIgnoreProperties(ignoreUnknown = true)
public class FoodModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name= "count")
  private Integer count;
  
  @Column(name = "type")
  @JsonIgnore
  private Integer type;
  
  @Column(name = "item_name")
  private String itemName;
  
  @Column(name = "status")
  private Boolean status;

  protected FoodModel(Integer id, Integer count, Integer type, String name, Boolean status) {
    super();
    this.id = id;
    this.count = count;
    this.type = type;
    this.itemName = name;
    this.status = status;
  }

  protected FoodModel() {
    super();
  }

  public final Integer getId() {
    return id;
  }

  public final void setId(Integer id) {
    this.id = id;
  }

  public final Integer getCount() {
    return count;
  }

  public final void setCount(Integer count) {
    this.count = count;
  }

  @JsonProperty(value= "item_name")
  public final String getItemName() {
    return itemName;
  }

  public final void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public final Integer getType() {
    return type;
  }

  public final void setType(Integer type) {
    this.type = type;
  }

  @JsonIgnore
  public final Boolean getStatus() {
    return status;
  }

  public final void setStatus(Boolean status) {
    this.status = status;
  }
  

}
