package com.example.jrest.controllers

import com.example.jrest.services.TodoInteractor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.rest.webmvc.RepositoryRestController
import org.springframework.hateoas.EntityModel
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

@RepositoryRestController
class TodosController(@Autowired private val todoInteractor: TodoInteractor) {
    @ResponseBody
    @RequestMapping("/todos/{todoId}/done", method = [RequestMethod.PUT])
    fun done(@PathVariable todoId: Int?): ResponseEntity<*> {
        val todo = todoInteractor.done(todoId ?: noId())
        return ResponseEntity.ok(EntityModel(todo))
    }

    @ResponseBody
    @RequestMapping("/todos/{todoId}/fail", method = [RequestMethod.PUT])
    fun fail(@PathVariable todoId: Int?): ResponseEntity<*> {
        val todo = todoInteractor.fail(todoId ?: noId())
        return ResponseEntity.ok(EntityModel(todo))
    }

    private fun <T> noId(): T {
        throw IllegalArgumentException("No id given")
    }
}
