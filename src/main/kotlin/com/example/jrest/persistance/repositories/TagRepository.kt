package com.example.jrest.persistance.repositories

import com.example.jrest.persistance.data.Tag
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TagRepository : CrudRepository<Tag, String> {
}
