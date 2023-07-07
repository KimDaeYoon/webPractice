package com.example.praticetodo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.praticetodo.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	Optional<Role> findByRolename(String rolename);
}
