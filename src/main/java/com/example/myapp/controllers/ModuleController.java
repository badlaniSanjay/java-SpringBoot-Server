package com.example.myapp.controllers;



import com.example.myapp.models.Course;
import com.example.myapp.models.Module;
import com.example.myapp.repositories.CourseRepository;
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
public class ModuleController {

    @Autowired
    ModuleRepository repository;

    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/api/modules")
    public List<Module> findAllModules() {
        return repository.findAllModules();
    }

    @GetMapping("/api/courses/{cid}/modules")
    public List<Module> findAllModulesForCourse(
            @PathVariable("cid") Integer courseId) {
        return repository.findAllModulesForCourse(courseId);
    }

    @PostMapping("/api/courses/{cid}/modules")
    public List<Module> addModuleToCourse(
            @PathVariable("cid") Integer courseId,
            @RequestBody Module newModule
    ) {
        Course course = courseRepository.findCourseById(courseId);
        newModule.setCourse(course);
        repository.save(newModule);
        return repository.findAllModulesForCourse(courseId);
    }

    @GetMapping("/api/modules/{mid}")
    public Module findModuleById(@PathVariable("mid") Integer id) {
        return repository.findModuleById(id);
    }

    @PutMapping("/api/modules/{id}")
    public List<Module> updateModule(@PathVariable("id") Integer id, @RequestBody Module module){

        Module moduleToBeUpdated = repository.findModuleById(id);
        moduleToBeUpdated = module;
        repository.save(moduleToBeUpdated);
        return repository.findAllModulesForCourse(moduleToBeUpdated.getCourse().getId());
    }

    @DeleteMapping("/api/modules/{id}")
    public List<Module> deleteModules(@PathVariable("id") Integer id){
        int courseId = repository.findModuleById(id).getCourse().getId();
        repository.deleteById(id);
        return repository.findAllModulesForCourse(courseId);
    }

}
