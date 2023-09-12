package com.example.pr2.dao.impl

import com.example.pr2.dao.BaseDao
import com.example.pr2.model.Person
import org.springframework.stereotype.Repository

@Repository
interface PersonDao: BaseDao<Person>{
    fun findPeopleByNameContainsIgnoreCase(name: String): Collection<Person>?
}