package com.example.pr2.model

import javax.persistence.Entity
import javax.persistence.Table
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "Car")
data class Car(
    @NotBlank(message = "Field model required")
    val model: String = "",
    @NotBlank(message = "Field brand required")
    val brand: String = "",
    @NotBlank(message = "Field enginePower required")
    val enginePower: Double = 0.0,
    @NotBlank(message = "Field manufacturer required")
    val manufactureYear: Int = 0
) : BaseEntity() {
    override fun toString(): String = "$brand, $model, $manufactureYear г."


}
