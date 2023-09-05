package com.example.pr2.model

data class Substance(
    val name: String = "",
    val type: String = "",
    val density: Double = Double.NaN,
    val rare: Boolean = false
) : BaseEntity(0) {
    override fun toString(): String = "$name, $type, плотность: $density драгоценное: ${if (rare) " да" else " нет"}"
}