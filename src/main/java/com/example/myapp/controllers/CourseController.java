package com.example.myapp.controllers;

import com.example.myapp.models.Course;
import com.example.myapp.services.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin("*")
public class CourseController {


  @Autowired
  CourseService service;

  @GetMapping("/api/courses")
  public List<Course> findAllCourses() {
    return service.findAllCourses();
  }

  @PostMapping("/api/courses")
  public List<Course> createCourse (@RequestBody Course Course){
    return service.createCourse(Course);
  }

  @GetMapping("/api/Courses/{cid}")
  public Course findCourseById(
          @PathVariable("cid") Integer id) {
    return service.findCourseById(id);
  }

  @DeleteMapping("/api/courses/{wid}")
  public List<Course> deleteCourse(
          @PathVariable("wid") Integer CourseId) {
    return service.deleteCourse(CourseId);
  }

  @PutMapping("api/courses/{cid}")
  public List<Course> updateCourse(@PathVariable("cid") int cid, @RequestBody Course Course) {
    return service.updateCourse(cid, Course);
  }

}