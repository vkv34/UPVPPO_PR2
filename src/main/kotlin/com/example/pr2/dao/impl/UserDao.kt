package com.example.pr2.dao.impl

import com.example.pr2.dao.BaseDao
import com.example.pr2.model.User
import org.springframework.stereotype.Repository

@Repository
interface UserDao : BaseDao<User> {
    fun findFirstByLoginIgnoreCase(login: String) : User?
}