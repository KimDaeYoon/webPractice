package com.example.praticetodo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.praticetodo.config.ApplicationConfig;
import com.example.praticetodo.repository.TodoRepository;

public class TodoJpaRun {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		TodoRepository todoRepository = context.getBean(TodoRepository.class);
	}

}
