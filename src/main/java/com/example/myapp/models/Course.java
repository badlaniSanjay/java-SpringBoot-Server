package com.example.myapp.models;

import java.util.ArrayList;
import java.util.List;

public class Course {

  private Long id;
  private String title;
  private List<Module> modules;

  public Course(Long id, String title) {
    this.id = id;
    this.title = title;
    modules = new ArrayList<>();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public List<Module> getModules() {
    return modules;
  }

  public void setModules(List<Module> modules) {
    this.modules = modules;
  }
}
