package com.example.praticetodo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.praticetodo.domain.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{ //domain, id type

	
	//	약속된 이름으로 쿼리문 만들면 알아서 만들어줌
	Optional<Todo> findByTodo(String todo);
	List<Todo> findByTodoContaining(String todo);
	List<Todo> findByTodoContaining(String todo, Pageable pageable);
	
	
	// 그냥 쿼리도 가능, 약속된걸로 못하는 복잡한거 일때
	@Query("select t from Todo t where t.todo like %:todo%") // jpql은 sql이랑 비슷한데, entity 기준으로 쿼리문 만듬, :는 변수로 인지
	List<Todo> findTodos(@Param("todo") String todo);
	
	@Query(nativeQuery = true, value = "select id, todo, done from todos where todo like %:todo%")
	List<Todo> findTodos2(@Param("todo") String todo);
}
