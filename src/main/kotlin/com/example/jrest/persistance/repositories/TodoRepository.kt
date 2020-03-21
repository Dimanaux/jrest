package com.example.jrest.persistance.repositories

import com.example.jrest.persistance.data.Todo
import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepository : JpaRepository<Todo, Int> {
}
