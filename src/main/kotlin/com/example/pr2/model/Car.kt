package com.example.pr2.model

class Car(
    id: Int = 0,
    val model: String = "",
    val brand: String = "",
    val enginePower: Double = 0.0,
    val manufactureYear: Int = 0
) : BaseEntity(id){
    override fun toString(): String  = "$brand, $model, $manufactureYear г."
}
