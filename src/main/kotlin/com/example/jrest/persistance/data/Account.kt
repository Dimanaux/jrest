package com.example.jrest.persistance.data

import javax.persistence.*

@Entity
data class Account(
        @Id @GeneratedValue
        var id: Int,
        var email: String,
        @ManyToOne
        var tag: Tag,
        @OneToMany
        var todos: List<Todo> = mutableListOf()
)
