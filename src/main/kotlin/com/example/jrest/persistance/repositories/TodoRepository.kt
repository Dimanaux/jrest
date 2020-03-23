package com.example.jrest.persistance.repositories

import com.example.jrest.persistance.data.Todo
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TodoRepository : CrudRepository<Todo, Int> {
}
