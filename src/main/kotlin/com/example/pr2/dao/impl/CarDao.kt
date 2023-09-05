package com.example.pr2.dao.impl

import com.example.pr2.dao.BaseDao
import com.example.pr2.model.Car
import org.springframework.stereotype.Component

@Component
class CarDao: BaseDao<Car>(
    initData = mutableListOf(
        Car(0, )
    )
)