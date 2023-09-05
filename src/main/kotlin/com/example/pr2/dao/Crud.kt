package com.example.pr2.dao

interface Crud<T> {
    fun create (obj : T) : T?
    fun read (): Collection<T>
    fun update (obj : T, id: Int = 0)
    fun delete (id: Int)
    fun getById(id: Int): T?
}