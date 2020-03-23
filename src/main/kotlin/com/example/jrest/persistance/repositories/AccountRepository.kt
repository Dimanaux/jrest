package com.example.jrest.persistance.repositories

import com.example.jrest.persistance.data.Account
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AccountRepository : CrudRepository<Account, Int> {
}
