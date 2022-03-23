package br.com.cobli.optimus.models

import java.util.UUID

data class User(
    val id: UUID? = null,
    val name: String,
    val email: String,
)
