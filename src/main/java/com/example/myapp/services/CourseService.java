package com.example.myapp.services;

import com.example.myapp.models.Course;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {


  private static List<Course> courses = new ArrayList<Course>();


  static {
      courses.add(new Course(123, "Course 1"));
      courses.add(new Course(234, "Course 2"));
    courses.add(new Course(345, "Course 3"));
    courses.add(new Course(456, "Course 4"));
    courses.add(new Course(567, "Course 5"));
  }



  public List<Course> findAllCourses() {
    return courses;
  }


  public List<Course> deleteCourse(Integer CourseId) {
    courses = courses
            .stream()
            .filter(Course -> !Course.getId().equals(CourseId))
            .collect(Collectors.toList());
    return courses;
  }

  public List<Course> createCourse(Course Course) {
    courses.add(Course);
    return courses;
  }

  public Course findCourseById(Integer id) {
    Course particularCourse = courses.stream().filter(Course -> Course.getId() == id).findAny().get();
    return particularCourse;
  }

  public List<Course> updateCourse(int wid, Course CourseTemp) {
    courses = courses.stream().map(temp -> temp.getId() == wid ? CourseTemp: temp).collect(Collectors.toList());

    return courses;
  }
}

