package com.example.jrest.persistance.repositories

import com.example.jrest.persistance.data.Tag
import org.springframework.data.repository.CrudRepository

interface TagRepository : CrudRepository<Tag, String> {
}
