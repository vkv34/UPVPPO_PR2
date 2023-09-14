package com.example.pr2.model

import javax.persistence.Entity
import javax.persistence.Table
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "Substance")
data class Substance(
    @NotBlank(message = "Field name required")
    val name: String = "",
    @NotBlank(message = "Field type required")
    val type: String = "",
    @NotBlank(message = "Field density required")
    val density: Double = Double.NaN,
    @NotBlank(message = "Field rare required")
    val rare: Boolean = false
) : BaseEntity(0) {
    override fun toString(): String = "$name, $type, плотность: $density драгоценное: ${if (rare) " да" else " нет"}"
}