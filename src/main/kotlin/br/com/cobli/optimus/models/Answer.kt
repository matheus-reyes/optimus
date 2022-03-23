package br.com.cobli.optimus.models

import java.time.LocalDateTime
import java.util.UUID

data class Answer(
    val id: UUID?,
    val message: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val author: User,
    val topic: Topic,
    val solution: Boolean,
)
