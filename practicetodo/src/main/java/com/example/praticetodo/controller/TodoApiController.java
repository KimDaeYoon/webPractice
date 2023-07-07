package com.example.praticetodo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.praticetodo.domain.Todo;
import com.example.praticetodo.service.TodoService;

@RestController //화면 응답 아님. 데이타만 응답
@RequestMapping("/v1/api/todos")
public class TodoApiController {
	private TodoService todoService;
	
//	@GetMapping("/bearerTest") // bearer token
//	@ApiOperation(value = "bearer token", notes = "bearer token 보여줌") // swagger에 description 보여줌 
//	public String bearerTest(@ApiIgnore @RequestHeader("Authorization") String key) {
//		return key;
//	}	
	
	TodoApiController(TodoService todoService){
		this.todoService = todoService;
	}
	
	@GetMapping
//	@ApiOperation(value = "전체 할일 보여주기", notes = "할일 보여줌") // swagger에 description 보여줌 
	public List<Todo> getTodos(){
		return todoService.getTodos();
	}
	
	@GetMapping("/{id}")
//	@ApiImplicitParam(name = "id", value = "할일 아이디", required = true, paramType = "path")
//	@ApiResponses({
//		@ApiResponse(code = 200, message = "성공"),
//		@ApiResponse(code = 500, message = "아이디 없음")
//		
//	})
	public Todo getTodo(@PathVariable("id") Long id) {
		return todoService.getTodo(id);
	}
	
	@PostMapping
	public Todo addTodo(@RequestBody Todo todo) {
		return todoService.addTodo(todo.getTodo());
	}
	
	@PatchMapping
	public Todo updateTodo(@RequestBody Todo todo) {
		return todoService.updateTodo(todo.getId());
	}
	
	@DeleteMapping
	public String deleteTodo(@RequestBody Todo todo) {
		todoService.deleteTodo(todo.getId());
		return "ok";
	}
}
