package com.example.pr2.dao.controller

import com.example.pr2.dao.BaseDao
import com.example.pr2.model.BaseEntity
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import java.util.NoSuchElementException
import java.util.logging.Level
import java.util.logging.Logger

abstract class BaseController<T : BaseEntity>(
    private val dao: BaseDao<T>,
    private val path: String,
    private val views: BaseViews
) {
    @GetMapping
    open fun getAll(
        model: Model
    ): String {
        model.addAttribute(
            "data",
            dao.read()
        )
        model.addAttribute("path", path)
        return "${views.listView}"
    }

    @GetMapping("/{id}")
    open fun getById(
        @PathVariable id: Int,
        model: Model,
    ): String {

        model.addAttribute(
            "data",
            dao.getById(id) ?: "Ничего не найдено"
        )
        model.addAttribute("path", path)


        return "${views.getByIdView}"
    }

    @GetMapping("/{id}/edit")
    open fun getEditView(
        @ModelAttribute entity: T,
        @PathVariable id: Int,
        model: Model
    ): String {
        model.addAttribute("path", path)
        model.addAttribute(
            "data",
            dao.getById(id) ?: "Ничего не найдено"
        )
        return "${views.editView}"
    }

    @PatchMapping("/{id}/patch")
    open fun patch(
        @PathVariable id: Int,
        @ModelAttribute entity: T,
        model: Model
    ): String {
        model.addAttribute("path", path)
        dao.update(entity, id)
        return "redirect:/$path"
    }

    @DeleteMapping("/{id}/delete")
    open fun delete(
        @PathVariable id: Int
    ): String {
        dao.delete(id)
        return "redirect:/$path"
    }

    @PostMapping("/create")
    fun create(
        @ModelAttribute entity: T
    ): String {
        val created = dao.create(entity)
        print("sadasdasdasdasdas")
        Logger.getLogger(javaClass.name).log(Level.INFO, "Я утт ")
        return if (created != null) "redirect:/$path/${created.id}/edit"
        else throw NoSuchElementException("Элемент не был создан")
    }

}