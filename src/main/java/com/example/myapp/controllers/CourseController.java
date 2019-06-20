package com.example.myapp.controllers;

import com.example.myapp.models.Course;
import com.example.myapp.repositories.CourseRepository;
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
  CourseRepository repository;

  @GetMapping("/api/courses")
  public List<Course> findAllCourses() {
    return repository.findAllCourses();
  }

  @PostMapping("/api/courses")
  public List<Course> createCourse (@RequestBody Course Course){
    repository.save(Course);
    return repository.findAllCourses();
  }

  @GetMapping("/api/courses/{cid}")
  public Course findCourseById(
          @PathVariable("cid") Integer id) {
    return repository.findCourseById(id);
  }

  @DeleteMapping("/api/courses/{cid}")
  public List<Course> deleteCourse(
          @PathVariable("cid") long CourseId) {
    Course courseToBeDeleted = repository.findCourseById((int)CourseId);
    repository.delete(courseToBeDeleted);
    return repository.findAllCourses();
  }

  @PutMapping("/api/courses/{cid}")
  public List<Course> updateCourse(@PathVariable("cid") long cid, @RequestBody Course Course) {
    Course courseToBeUpdated = repository.findCourseById((int) cid);
    courseToBeUpdated = Course;
    repository.save(courseToBeUpdated);
    return repository.findAllCourses();
  }

}