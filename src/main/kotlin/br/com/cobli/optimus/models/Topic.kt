package br.com.cobli.optimus.models

import java.time.LocalDateTime
import java.util.UUID
import kotlin.collections.ArrayList

data class Topic(
    val id: UUID? = null,
    val title: String,
    val message: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val course: Course,
    val author: User,
    val status: StatusTopic = StatusTopic.NOT_ANSWERED,
    val answers: List<Answer> = ArrayList(),
)
