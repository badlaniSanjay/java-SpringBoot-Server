package com.example.myapp.controllers;

import com.example.myapp.models.Lesson;
import com.example.myapp.models.Module;
import com.example.myapp.repositories.LessonRepository;
import com.example.myapp.repositories.ModuleRepository;

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
public class LessonController {


  @Autowired
  LessonRepository repository;

  @Autowired
  ModuleRepository moduleRepository;

  @GetMapping("/api/lessons")
  public List<Lesson> findAllLessons() {
    return repository.findAllLessons();
  }

  @GetMapping("/api/modules/{mid}/lessons")
  public List<Lesson> findAllModulesForCourse(
          @PathVariable("mid") Integer moduleId) {
    return repository.findAllLessonsFforModule(moduleId);
  }

  @PostMapping("/api/modules/{mid}/lessons")
  public void addLessonToModule(
          @PathVariable("mid") Integer moduleId,
          @RequestBody Lesson lesson
  ) {
    Module module = moduleRepository.findModuleById(moduleId);
    lesson.setModule(module);
    repository.save(lesson);
  }

  @GetMapping("/api/lessons/{id}")
  public Lesson findLessonById(@PathVariable("id") Integer id) {
    return repository.findLessonById(id);
  }

  @PutMapping("/api/lessons/{id}")
  public void updateModule(@PathVariable("id") Integer id, @RequestBody Lesson lesson){

    Lesson lessonToBeUpdated = repository.findLessonById(id);
    lessonToBeUpdated = lesson;
    repository.save(lessonToBeUpdated);
  }

  @DeleteMapping("/api/lessons/{id}")
  public void deleteModules(@PathVariable("id") Integer id){
    repository.deleteById(id);

  }

}
