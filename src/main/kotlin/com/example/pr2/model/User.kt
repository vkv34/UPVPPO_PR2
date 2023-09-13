package com.example.pr2.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.OneToOne
import jakarta.persistence.Table

@Entity
@Table(name = "U")
data class User(

    @Column(unique = true)
    val nickname: String = "",

    @OneToOne(optional = true, mappedBy = "user")
    val person: Person? = null

): BaseEntity(){
    override fun toString(): String = nickname
}