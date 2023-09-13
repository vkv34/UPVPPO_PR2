package com.example.pr2.dao.controller.impl

import com.example.pr2.dao.controller.BaseController
import com.example.pr2.dao.controller.BaseViews
import com.example.pr2.dao.impl.PersonDao
import com.example.pr2.dao.impl.TownDao
import com.example.pr2.model.Person
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@RequestMapping("/people")
@Controller
class PeopleController(
    @Autowired val personDao: PersonDao,
    @Autowired val townDao: TownDao
) : BaseController<Person>(
    dao = personDao,
    path = "people",
    views = BaseViews(
        editView = "edit_people"
    ),
    search = { personDao.findPeopleByNameContainsIgnoreCase(it) }
) {
    @GetMapping("/{id}/edit")
    override fun getEditView(
        @ModelAttribute entity: Person,
        @PathVariable id: Long,
        model: Model
    ): String {
        val towns = townDao.findAll().toList()
        model.addAttribute("towns", towns)
        return super.getEditView(entity, id, model)
    }

    @PatchMapping("/{id}/patch")
    override fun patch(
        @PathVariable id: Long,
        @ModelAttribute @Valid entity: Person,
//        bindingResult: BindingResult,
        model: Model,
//        @RequestParam(value = "town") town: String
    ): String {
        entity.town = townDao.findAllByNameContainsIgnoreCase(entity.townString)?.first()
        return super.patch(id, entity, model)
    }
}
