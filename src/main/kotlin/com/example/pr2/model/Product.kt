package com.example.pr2.model

import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

@Entity
@Table(name = "Product")
data class Product(
    @NotBlank(message = "Field name required")
    @Size(min = 3, message = "Name length must be more than 3")
    val name: String = "",
    @NotBlank(message = "Field cost required")
    val cost: Double = Double.NaN,
    @NotBlank(message = "Field description required")
    val description: String = "",
    @NotBlank(message = "Field rate required")
    val rate : Byte = 0
) : BaseEntity(){
    override fun toString(): String = "$name, $cost руб., оценка: $rate"
}
