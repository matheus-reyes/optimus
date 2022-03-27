package br.com.cobli.optimus.model

import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Course(
    @Id
    val id: UUID? = UUID.randomUUID(),
    val name: String,
    val category: String,
)
