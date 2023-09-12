package com.example.pr2.dao.impl

import com.example.pr2.dao.BaseDao
import com.example.pr2.model.Product
import org.springframework.stereotype.Repository

@Repository
interface ProductDao: BaseDao<Product>{
    fun findAllByNameContainsIgnoreCase(name: String): Collection<Product>?
}