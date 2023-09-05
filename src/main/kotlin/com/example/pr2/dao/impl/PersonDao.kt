package com.example.pr2.dao.impl

import com.example.pr2.dao.BaseDao
import com.example.pr2.model.Person
import org.springframework.stereotype.Component

@Component
class PersonDao: BaseDao<Person>(
    initData = mutableListOf(
        Person(id = 0, "Иван", "Иванов", "Иванович", 5),
        Person(id = 1, "Иван", "Иванов", "Иванович", 5),
        Person(id = 2, "Иван", "Иванов", "Иванович", 5),
        Person(id = 3, "Иван", "Иванов", "Иванович", 5),
    )
)