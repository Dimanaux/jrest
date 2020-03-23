package com.example.jrest.controllers

import com.example.jrest.persistance.data.Todo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks
import org.springframework.hateoas.EntityModel
import org.springframework.hateoas.server.RepresentationModelProcessor
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn
import org.springframework.stereotype.Component

@Component
class TodoPresenter(@Autowired private val links: RepositoryEntityLinks)
    : RepresentationModelProcessor<EntityModel<Todo>> {

    override fun process(model: EntityModel<Todo>): EntityModel<Todo> {
        val todo: Todo = model.content ?: throw IllegalArgumentException("No todo found")
        if (todo.canBeDone()) {
            model.add(linkTo(methodOn(TodosController::class.java).done(todo.id!!)!!).withRel("done"))
        }
        if (todo.canBeFailed()) {
            model.add(linkTo(methodOn(TodosController::class.java).fail(todo.id!!)!!).withRel("fail"))
//            model.add(links.linkToItemResource(Todo::class.java, todo.id!!).withRel("fail"))
        }
        return model
    }
}
