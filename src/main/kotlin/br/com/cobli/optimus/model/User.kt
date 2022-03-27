package br.com.cobli.optimus.model

import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class User(
    @Id
    val id: UUID? = UUID.randomUUID(),
    val name: String,
    val email: String,
)
