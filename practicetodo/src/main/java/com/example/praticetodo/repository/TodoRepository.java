package com.example.praticetodo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.praticetodo.domain.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{ //domain, id type

}
