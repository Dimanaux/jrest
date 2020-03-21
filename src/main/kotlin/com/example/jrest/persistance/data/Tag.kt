package com.example.jrest.persistance.data

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToMany

@Entity
data class Tag(
        @Id
        val label: String,
        @ManyToMany(mappedBy = "tags")
        val todos: MutableSet<Todo> = mutableSetOf()
)
