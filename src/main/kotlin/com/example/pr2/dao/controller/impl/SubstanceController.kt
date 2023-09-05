package com.example.pr2.dao.controller.impl

import com.example.pr2.dao.controller.BaseController
import com.example.pr2.dao.controller.BaseViews
import com.example.pr2.dao.impl.ProductDao
import com.example.pr2.dao.impl.SubstanceDao
import com.example.pr2.model.Product
import com.example.pr2.model.Substance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/sub")
@Controller
class SubstanceController(
    @Autowired dao: SubstanceDao
): BaseController<Substance>(
    dao = dao,
    path = "sub",
    views = BaseViews(
        editView = "edit_substance"
    )
)