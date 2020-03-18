package com.example.jrest.persistance.data

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToMany

@Entity
data class Tag(
        @Id
        var label: String,
        @ManyToMany
        val todos: Set<Todo>
)
