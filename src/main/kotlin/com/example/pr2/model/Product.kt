package com.example.pr2.model

class Product(
    val name: String = "",
    val cost: Double = Double.NaN,
    val description: String = "",
    val rate : Byte = 0
) : BaseEntity(0){
    override fun toString(): String = "$name, $cost руб., оценка: $rate"
}
