package com.example.pr2.dao

import com.example.pr2.model.BaseEntity
import java.util.logging.Level
import java.util.logging.Logger

abstract class BaseDao<T : BaseEntity>(
    initData: MutableList<T> = mutableListOf()
) : Crud<T> {

    protected open val data = initData

    override fun create(obj: T): T? {
        val id = generateId()
        data.add(obj.apply { this.id = id })
        return getById(id)
    }

    override fun read(): Collection<T> = data

    override fun update(obj: T, id: Int) {
        if (id == 0) {
            data.removeIf { it.id == obj.id }
        } else {
            data.removeIf { it.id == id }
        }
        data.add(obj)
    }

    override fun delete(id: Int) {
        data.removeIf {
            it.id == id

        }
    }

    override fun getById(id: Int): T? = data.firstOrNull { it.id == id }

    open fun generateId(): Int = data.maxByOrNull { it.id }?.id?.inc() ?: 0
}