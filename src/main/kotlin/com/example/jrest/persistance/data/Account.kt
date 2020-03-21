package com.example.jrest.persistance.data

import javax.persistence.*

@Entity
data class Account(
        @Id @GeneratedValue
        var id: Int? = null,
        var email: String,
        @OneToMany @JoinColumn(name = "account_id")
        var todos: List<Todo> = mutableListOf()
) {
    constructor(email: String) : this(null, email)
    constructor() : this("")
}
