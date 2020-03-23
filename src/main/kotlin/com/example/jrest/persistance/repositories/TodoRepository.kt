package com.example.jrest.persistance.repositories

import com.example.jrest.persistance.data.Todo
import org.springframework.data.repository.CrudRepository

interface TodoRepository : CrudRepository<Todo, Int> {
}
