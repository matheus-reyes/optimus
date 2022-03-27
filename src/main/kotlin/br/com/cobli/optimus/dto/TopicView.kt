package br.com.cobli.optimus.dto

import br.com.cobli.optimus.model.StatusTopic
import java.time.LocalDateTime
import java.util.UUID

data class TopicView (
        val id: UUID?,
        val title: String,
        val message: String,
        val status: StatusTopic,
        val createdAt: LocalDateTime,
)
