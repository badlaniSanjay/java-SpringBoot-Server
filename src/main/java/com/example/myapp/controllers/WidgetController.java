package com.example.myapp.controllers;

import com.example.myapp.models.Widget;
import com.example.myapp.services.WidgetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
public class WidgetController {


  @Autowired
  WidgetService service;

  @GetMapping("/api/widgets")
  public List<Widget> findAllWidgets() {
    return service.findAllWidgets();
  }

  @PostMapping("/api/widgets")
  public List<Widget> createWidget (@RequestBody Widget widget){
    return service.createWidget(widget);
  }

  @GetMapping("/api/widgets/{wid}")
  public Widget findWidgetById(
          @PathVariable("wid") long id) {
    return service.findWidgetById(id);
  }

  @DeleteMapping("/api/widgets/{wid}")
  public List<Widget> deleteWidget(
          @PathVariable("wid") long widgetId) {
    return service.deleteWidget(widgetId);
  }

  @PutMapping("api/widgets/{wid}")
  public List<Widget> updateWidget(@PathVariable("wid") long wid, @RequestBody Widget widget) {
    return service.updateWidget(wid, widget);
  }

}