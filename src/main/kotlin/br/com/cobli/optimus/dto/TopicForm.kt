package br.com.cobli.optimus.dto

import java.util.UUID

data class TopicForm (
        val title : String,
        val message: String,
        val courseId: UUID,
        val authorId: UUID,
)
