package com.example.jrest.controllers

import com.example.jrest.persistance.data.Todo
import com.example.jrest.persistance.repositories.TodoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.data.rest.webmvc.RepositoryRestController
import org.springframework.hateoas.EntityModel
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

@RepositoryRestController
class TodosController(@Autowired private val todoRepository: TodoRepository) {
    @ResponseBody
    @RequestMapping("/todos/{todoId}/done", method = [RequestMethod.PUT])
    fun done(@PathVariable todoId: Int?): ResponseEntity<*>? {
        val todo: Todo = todoRepository.findByIdOrNull(todoId)
                ?: return ResponseEntity.notFound().build<Any>()
        todo.done()
        todoRepository.save(todo)
        return ResponseEntity.ok(EntityModel(todo))
    }

    @ResponseBody
    @RequestMapping("/todos/{todoId}/fail", method = [RequestMethod.PUT])
    fun fail(@PathVariable todoId: Int?): ResponseEntity<*>? {
        val todo: Todo = todoRepository.findByIdOrNull(todoId)
                ?: return ResponseEntity.notFound().build<Any>()
        todo.fail()
        todoRepository.save(todo)
        return ResponseEntity.ok(EntityModel(todo))
    }
}
