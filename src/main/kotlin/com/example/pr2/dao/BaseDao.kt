package com.example.pr2.dao

import com.example.pr2.model.BaseEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.NoRepositoryBean

@NoRepositoryBean
interface BaseDao<T : BaseEntity> : CrudRepository<T, Long>
