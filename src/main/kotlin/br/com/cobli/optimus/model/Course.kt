package br.com.cobli.optimus.model

import java.util.UUID

data class Course(
    val id: UUID? = UUID.randomUUID(),
    val name: String,
    val category: String,
)
