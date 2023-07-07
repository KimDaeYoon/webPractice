package com.example.praticetodo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.praticetodo.config.ApplicationConfig;
import com.example.praticetodo.domain.Todo;
import com.example.praticetodo.repository.TodoRepository;
import com.example.praticetodo.service.TodoService;

public class TodoJpaRun {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		TodoRepository todoRepository = context.getBean(TodoRepository.class);
		TodoService todoService = context.getBean(TodoService.class);
		
		// C : save
		Todo todo = new Todo();
		todo.setTodo("jpa study");
		
		System.out.println(todo);
		todo = todoService.addTodo(todo.getTodo());
		System.out.println(todo);
		
		// R : read
		
//		todoRepository.findById(9L);
//		
//		List<Todo> list = new ArrayList();
//		list = todoRepository.findAll();
//	
//		for (Todo todo2 : list) {
//			System.out.println(todo2);
//		}
		
		// pageable 가능
		
		
		// U : update
	
//		todoService.updateTodo(9L);
		
		// D : delete
		
//		todoService.deleteTodo(8L);
		
		
	}

}
