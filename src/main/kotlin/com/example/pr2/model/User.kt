package com.example.pr2.model


import javax.persistence.*

@Entity
@Table(name = "U")
data class User(

    @Column(unique = true)
    val nickname: String = "",

    @Column(unique = true)
    val login: String = "",
    val password: String = "",

    @ElementCollection(targetClass = Role::class, fetch = FetchType.EAGER) @CollectionTable(
        name = "user_role",
        joinColumns = [JoinColumn(name = "user_id")]
    ) @Enumerated(
        EnumType.STRING
    )
    val roles: Set<Role>? = null,

    @OneToOne(optional = true, mappedBy = "user")
    val person: Person? = null

): BaseEntity(){
    override fun toString(): String = nickname
}