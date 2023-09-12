package com.example.pr2.dao.impl

import com.example.pr2.dao.BaseDao
import com.example.pr2.model.Car
import org.springframework.stereotype.Repository


@Repository
interface CarDao : BaseDao<Car>{
    fun findCarsByModelContainsIgnoreCase(model: String): List<Car>?
}