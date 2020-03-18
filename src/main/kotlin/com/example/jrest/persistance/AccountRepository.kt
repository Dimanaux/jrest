package com.example.jrest.persistance

import com.example.jrest.persistance.data.Account
import org.springframework.data.repository.CrudRepository

interface AccountRepository : CrudRepository<Account, Int> {
}
