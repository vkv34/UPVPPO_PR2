package com.example.pr2.model

import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import jakarta.validation.constraints.NotBlank

@Entity
@Table(name = "Town")
data class Town(
    @NotBlank(message = "Field name required")
    val name: String = "",
    @NotBlank(message = "Field name required")
    val square: Double = Double.NaN,
    @NotBlank(message = "Field name required")
    val population: Int = 0,
    @NotBlank(message = "Field name required")
    val country: String = "",
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "town")
    val peoples: Set<Person> = setOf()
) : BaseEntity(){
    override fun toString(): String = "${country}, $name, площадь: $square км2, население: $population"
}
