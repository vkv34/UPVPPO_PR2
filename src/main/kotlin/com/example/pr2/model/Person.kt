package com.example.pr2.model

class Person(
    id: Int = 0,
    val name: String = "",
    val surname: String = "",
    val lastname: String = "",
    val age: Int = 0
) : BaseEntity(id){
    override fun toString(): String = "$surname $name $lastname возраст:$age"
}
