package com.example.pr2.account.controller

import com.example.pr2.dao.impl.PersonDao
import com.example.pr2.dao.impl.TownDao
import com.example.pr2.dao.impl.UserDao
import com.example.pr2.model.Person
import com.example.pr2.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/registration")
@Controller
class RegistrationController @Autowired constructor(
    val personDao: PersonDao,
    val userDao: UserDao,
    val townDao: TownDao
) {


    @GetMapping
    fun regView(): String{
        println()
        println()
        println()
        println()
        println()

        return "registration"
    }

    @PostMapping
    fun register(
        @ModelAttribute person: Person,
        model: Model
    ): String {
        val existsUser = userDao.findFirstByLoginIgnoreCase(person.login)
        if (existsUser != null) {
            model.addAttribute("message", "Пользователь с таким логином уже существует")
            return "registration"
        }
        val towns = townDao.findAll().toList()
        model.addAttribute("towns", towns)
        personDao.save(
            person.copy(
                user = User(
                    login = person.login,
                    password = BCryptPasswordEncoder().encode(person.password)
                )
            )
        )

        return "redirect:/login"

    }


}