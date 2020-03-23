package com.example.jrest.persistance.data

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Tag(
        @Id
        val label: String
)
