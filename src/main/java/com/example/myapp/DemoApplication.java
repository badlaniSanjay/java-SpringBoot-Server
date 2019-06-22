package com.example.myapp;

import com.example.myapp.controllers.WidgetController;
import com.example.myapp.models.Widget;
import com.example.myapp.repositories.WidgetRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication {



	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}

}
