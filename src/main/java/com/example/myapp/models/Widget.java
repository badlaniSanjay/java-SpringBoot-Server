package com.example.myapp.models;

import com.example.myapp.Enums.DataType;
import com.example.myapp.Enums.WidgetType;

public class Widget {

  private Integer id;
  private String name;
  private WidgetType type;
  private Integer order;
  private String text;
  private String src;
  private String size;
  private Integer width;
  private Integer height;
  private String cssClass;
  private String stye;
  private String value;
  private DataType dataType;


  public Widget(Integer id, String name, WidgetType type, Integer order, String text) {
    this.id = id;
    this.name = name;
    this.type = type;
    this.order = order;
    this.text = text;
  }


  public Widget() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public WidgetType getType() {
    return type;
  }

  public void setType(WidgetType type) {
    this.type = type;
  }

  public Integer getOrder() {
    return order;
  }

  public void setOrder(Integer order) {
    this.order = order;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getSrc() {
    return src;
  }

  public void setSrc(String src) {
    this.src = src;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public Integer getWidth() {
    return width;
  }

  public void setWidth(Integer width) {
    this.width = width;
  }

  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }

  public String getCssClass() {
    return cssClass;
  }

  public void setCssClass(String cssClass) {
    this.cssClass = cssClass;
  }

  public String getStye() {
    return stye;
  }

  public void setStye(String stye) {
    this.stye = stye;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public DataType getDataType() {
    return dataType;
  }

  public void setDataType(DataType dataType) {
    this.dataType = dataType;
  }
}
