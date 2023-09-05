package com.example.pr2.dao.controller.impl

import com.example.pr2.dao.controller.BaseController
import com.example.pr2.dao.controller.BaseViews
import com.example.pr2.dao.impl.ProductDao
import com.example.pr2.dao.impl.TownDao
import com.example.pr2.model.Product
import com.example.pr2.model.Town
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/towns")
@Controller
class TownsController(
    @Autowired dao: TownDao
): BaseController<Town>(
    dao = dao,
    path = "towns",
    views = BaseViews(
        editView = "edit_town"
    )
)