package com.example.praticetodo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.praticetodo.domain.Todo;
import com.example.praticetodo.service.TodoService;

//@RestController
@Controller
@RequestMapping("/todo")
public class TodoController {
	
	private TodoService todoService;
	
	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		
		List<Todo> todos = todoService.getTodos();
		model.addAttribute("todoList", todos);
		
		return "list";
	}
	
	@PostMapping("/add")
	public String add(@RequestParam("todo") String todo) {
		todoService.addTodo(todo);
		
		return "redirect:/todo/list"; //redirect가 되야함. spring에서는 약속된 접두어 가짐
	}
	
	@GetMapping("/update")
	public String Update(@RequestParam("id") Long id ) { // @requestParam 하면 알아서 spring이 넣어줌
		todoService.updateTodo(id);
		return "redirect:/todo/list"; //redirect가 되야함. spring에서는 약속된 접두어 가짐
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id") Long id) {
		todoService.deleteTodo(id);
		return "redirect:/todo/list";  
	}
}
