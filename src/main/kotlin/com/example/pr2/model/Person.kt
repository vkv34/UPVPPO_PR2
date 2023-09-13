package com.example.pr2.model

import jakarta.persistence.*
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank

@Entity
@Table(name = "Person")
data class Person(
    @field:NotBlank(message = "Field name required")
    val name: String = "-",
    @field:NotBlank (message = "Field surname required")
    val surname: String = "-",
    @NotBlank(message = "Field lastname required")
    val lastname: String = "-",
    @NotBlank(message = "Field age required")
    @Min(value =  0, message = "Age must more then 0")
    val age: Int = 0,
    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.MERGE], optional = true)
    @JoinColumn(name = "town_id", nullable = true)
    val town: Town? = null,
    @OneToOne(optional = true)
    @JoinColumn(name = "user_id", unique = true, nullable = true, )
    val user: User? = null
) : BaseEntity(){
    override fun toString(): String = "$surname $name $lastname возраст:$age"
}
