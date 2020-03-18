package com.example.jrest.persistance.data

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToMany

@Entity
data class Todo(
        @Id @GeneratedValue
        val id: Int,
        val text: String,
        @ManyToMany
        val tags: List<Tag> = mutableListOf()
)