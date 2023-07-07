package com.example.praticetodo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.praticetodo.domain.Todo;
import com.example.praticetodo.repository.TodoRepository;

@Service
public class TodoService {

	private TodoRepository todoRepository;

	public TodoService(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}
	

	@Transactional(readOnly = true)
	public List<Todo> getTodos() {

//		return todoDao.getTodos();
		return todoRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Todo getTodo(Long id) {

//		return todoDao.getTodo(id);
		return todoRepository.getById(id);
	}

	@Transactional
	public Todo addTodo(String todo) {

//		return todoDao.addTodo(todo);
		return todoRepository.save(new Todo(1L, todo, false));
	}

	@Transactional // for performance
	public Todo updateTodo(Long id) {
		Todo updateTodo = null;
		try {
			updateTodo = todoRepository.findById(id).orElseThrow();
			updateTodo.setDone(!updateTodo.isDone());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("update done!!");
		}
		return updateTodo;

	}
	
	public void deleteTodo(Long id) {
		Optional<Todo> findTodo = todoRepository.findById(id);
		
		if (findTodo.isEmpty()) {
			return;
		}
		
		todoRepository.delete(findTodo.get());
	}
}
