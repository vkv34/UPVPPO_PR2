package com.example.pr2.dao.controller.impl

import com.example.pr2.dao.controller.BaseController
import com.example.pr2.dao.controller.BaseViews
import com.example.pr2.dao.impl.PersonDao
import com.example.pr2.model.Person
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/people")
@Controller
class PeopleController (
    @Autowired val personDao: PersonDao
) : BaseController<Person>(
    dao = personDao,
    path = "people",
    views = BaseViews(
        editView = "edit_people"
    ),
    search = { personDao.findPeopleByNameContainsIgnoreCase(it) }
)