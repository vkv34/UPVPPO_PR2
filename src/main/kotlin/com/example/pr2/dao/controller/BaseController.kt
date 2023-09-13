package com.example.pr2.dao.controller

import com.example.pr2.dao.BaseDao
import com.example.pr2.model.BaseEntity
import jakarta.validation.Valid
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import kotlin.jvm.optionals.getOrNull


abstract class BaseController<T : BaseEntity>(
    protected val dao: BaseDao<T>,
    private val path: String,
    protected val views: BaseViews,
    protected inline val search: (search: String) -> Collection<T>? = { listOf()}
) {
    @GetMapping
    open fun getAll(
        model: Model
    ): String {
        model.addAttribute(
            "data",
            dao.findAll()
        )
        model.addAttribute("path", path)
        return "${views.listView}"
    }

    @GetMapping("/{id}")
    open fun getById(
        @PathVariable id: Long,
        model: Model,
    ): String {

        model.addAttribute(
            "data",
            dao.findById(id).getOrNull() ?: "Ничего не найдено"
        )
        model.addAttribute("path", path)


        return "${views.getByIdView}"
    }

    @GetMapping("/{id}/edit")
    open fun getEditView(
        @ModelAttribute entity: T,
        @PathVariable id: Long,
        model: Model
    ): String {
        model.addAttribute("path", path)
        model.addAttribute(
            "data",
            dao.findById(id).getOrNull() ?: "Ничего не найдено"
        )
        return "${views.editView}"
    }

    @PatchMapping("/{id}/patch")
    open fun patch(
        @PathVariable id: Long,
        @ModelAttribute @Valid entity: T,
//        bindingResult: BindingResult,
        model: Model
    ): String {
        model.addAttribute("path", path)

        entity.id = id
//        if (bindingResult.hasErrors()){
//            dao.delete(entity)
//            print(bindingResult.getRawFieldValue("name"))
//            throw ValidationException(bindingResult.suppressedFields.joinToString { ", " })
//        }
        dao.save(entity)
        return "redirect:/$path"
    }

    @DeleteMapping("/delete/{id}")
    open fun delete(
        @PathVariable id: Int
    ): String {
        dao.delete(dao.findById(id.toLong()).orElseThrow())
        return "redirect:/$path"
    }

    @PostMapping("/create")
    fun create(
        @ModelAttribute entity: T
    ): String {
        val created = dao.save(entity)
        print("sadasdasdasdasdas")
        return if (created != null) "redirect:/$path/${created.id}/edit"
        else throw NoSuchElementException("Элемент не был создан")
    }

    @GetMapping(params = ["search"])
    fun search(
        model: Model,
        @RequestParam(value = "search") search: String
    ): String {
        model.addAttribute(
            "data",
            search(search)
        )
        model.addAttribute("path", path)
        return "${views.listView}"
    }

//    @ExceptionHandler(ValidationException::class)
//    @ResponseBody
//    protected fun handleDMSRESTException(objException: ValidationException?): String  {
//        return objException?.message?.ifBlank { "Validation Errors" }?:"Validation Errors"
//    }

}