package com.example.myapp.controllers;

import com.example.myapp.models.Lesson;
import com.example.myapp.models.Topic;
import com.example.myapp.repositories.LessonRepository;
import com.example.myapp.repositories.TopicRepository;

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
public class TopicController {


  @Autowired
  TopicRepository repository;

  @Autowired
  LessonRepository lessonRepository;

  @GetMapping("/api/topics")
  public List<Topic> findAllTopics() {
    return repository.findAllTopics();
  }

  @GetMapping("/api/lessons/{lid}/topics")
  public List<Topic> findAllTopicsFroLesson(
          @PathVariable("lid") Integer lessonId) {
    return repository.findAllTopicsForLesson(lessonId);
  }

  @PostMapping("/api/lessons/{lid}/topics")
  public void addTopicToLesson(
          @PathVariable("lid") Integer lessonId,
          @RequestBody Topic topic
  ) {
    Lesson lesson  = lessonRepository.findLessonById(lessonId);
    topic.setLesson(lesson);
    repository.save(topic);
  }

  @GetMapping("/api/topics/{id}")
  public Topic findTopicById(@PathVariable("id") Integer id) {
    return repository.findTopicById(id);
  }

  @PutMapping("/api/topics/{id}")
  public void updateTopic(@PathVariable("id") Integer id, @RequestBody Topic topic){

    Topic topicToBeUpdated = repository.findTopicById(id);
    topicToBeUpdated  = topic;
    repository.save(topicToBeUpdated);
  }

  @DeleteMapping("/api/topics/{id}")
  public void deleteTopic(@PathVariable("id") Integer id){
    repository.deleteById(id);

  }

}
