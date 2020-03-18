package com.example.jrest.persistance

import com.example.jrest.persistance.data.Tag
import org.springframework.data.repository.CrudRepository

interface TagRepository : CrudRepository<Tag, String> {
}