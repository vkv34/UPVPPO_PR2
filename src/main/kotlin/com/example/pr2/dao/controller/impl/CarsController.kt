package com.example.pr2.dao.controller.impl

import com.example.pr2.dao.controller.BaseController
import com.example.pr2.dao.controller.BaseViews
import com.example.pr2.dao.impl.CarDao
import com.example.pr2.model.Car
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/cars")
@Controller
class CarsController(
    @Autowired carsDao: CarDao
): BaseController<Car>(
    dao = carsDao,
    path = "cars",
    views = BaseViews(
        editView = "edit_car"
    )
)