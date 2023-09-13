package com.example.pr2.dao.controller.impl

import com.example.pr2.dao.controller.BaseController
import com.example.pr2.dao.controller.BaseViews
import com.example.pr2.dao.impl.PersonDao
import com.example.pr2.dao.impl.TownDao
import com.example.pr2.model.Person
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/people")
@Controller
class PeopleController (
    @Autowired val personDao: PersonDao,
    @Autowired val townDao: TownDao
) : BaseController<Person>(
    dao = personDao,
    path = "people",
    views = BaseViews(
        editView = "edit_people"
    ),
    search = { personDao.findPeopleByNameContainsIgnoreCase(it) }
){
    override fun patch(id: Long, entity: Person, bindingResult: BindingResult, model: Model): String {
        model.addAttribute("towns", townDao.findAll())
        return super.patch(id, entity, bindingResult, model)
    }
}
