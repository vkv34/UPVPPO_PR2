package com.example.pr2.dao.impl

import com.example.pr2.dao.BaseDao
import com.example.pr2.model.Substance
import org.springframework.stereotype.Repository

@Repository
interface SubstanceDao: BaseDao<Substance>{
    fun findSubstancesByNameContainsIgnoreCase(name: String): Collection<Substance>?
}