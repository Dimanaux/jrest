package com.example.jrest

import com.example.jrest.persistance.data.Account
import com.example.jrest.persistance.data.Tag
import com.example.jrest.persistance.data.Todo
import com.example.jrest.persistance.repositories.AccountRepository
import com.example.jrest.persistance.repositories.TagRepository
import com.example.jrest.persistance.repositories.TodoRepository
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JrestApplication

fun main(args: Array<String>) {
    val applicationContext = runApplication<JrestApplication>(*args)
    val tagRepository = applicationContext.getBean(TagRepository::class.java)
    val accountRepository = applicationContext.getBean(AccountRepository::class.java)
    val todoRepository = applicationContext.getBean(TodoRepository::class.java)

    if (accountRepository.findAll().any()) {
        return
    }

    val health = Tag("health")
    val workout = Tag("workout")
    tagRepository.saveAll(setOf(health, workout))

    val user = Account("user@example.com")
    accountRepository.save(user)

    val exercise = Todo("Exercise", user, health, workout)
    val drinkWater = Todo("Drink water", user, health)

    todoRepository.saveAll(setOf(exercise, drinkWater))
}
