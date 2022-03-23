package br.com.cobli.optimus.models

import java.util.UUID

data class Course(
    val id: UUID? = null,
    val nome: String,
    val category: String,
)
