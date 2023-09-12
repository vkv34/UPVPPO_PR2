package com.example.pr2.dao.impl

import com.example.pr2.dao.BaseDao
import com.example.pr2.model.Town
import org.springframework.stereotype.Repository

@Repository
interface TownDao: BaseDao<Town>{
    fun findAllByNameContainsIgnoreCase(name: String): Collection<Town>?
}