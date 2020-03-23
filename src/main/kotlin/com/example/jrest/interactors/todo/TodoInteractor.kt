package com.example.jrest.interactors.todo

import com.example.jrest.persistance.data.Todo
import com.example.jrest.persistance.repositories.TodoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class TodoInteractor {
    @Autowired
    lateinit var todoRepository: TodoRepository

    fun fail(todoId: Int) = todoById(todoId).also { fail(it) }

    fun fail(todo: Todo) {
        if (todo.canBeFailed()) {
            todo.fail()
//            todo.save()
        } else {
            throw IllegalStateException("Can fail only new Todo")
        }
    }

    fun done(todoId: Int) = todoById(todoId).also { done(it) }

    fun done(todo: Todo) {
        if (todo.canBeDone()) {
            todo.done()
//            todo.save()
        } else {
            throw IllegalStateException("Can do only new Todo")
        }
    }

    fun todoById(id: Int) = todoRepository.findByIdOrNull(id)
            ?: throw IllegalArgumentException("Todo with id = $id not found")

    private fun Todo.save() {
        todoRepository.save(this)
    }
}
