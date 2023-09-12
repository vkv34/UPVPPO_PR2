package com.example.pr2.dao

import jakarta.persistence.Transient
import org.springframework.data.repository.NoRepositoryBean

@NoRepositoryBean
interface Crud<T> {
    fun create (obj : T) : T?
    @Transient
    @java.beans.Transient
    fun asb (): Collection<T>
    fun update (obj : T, id: Int = 0)
    fun delete (id: Int)
    fun getById(id: Int): T?
}