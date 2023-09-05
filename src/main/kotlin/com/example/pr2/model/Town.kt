package com.example.pr2.model

class Town(
    id: Int = 0,
    val name: String = "",
    val square: Double = Double.NaN,
    val population: Int = 0,
    val country: String = ""
) : BaseEntity(id){
    override fun toString(): String = "${country}, $name, площадь: $square км2, население: $population"
}
