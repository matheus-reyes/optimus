package br.com.cobli.optimus.model

import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
data class Answer(
    @Id
    val id: UUID? = UUID.randomUUID(),
    val message: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    @ManyToOne
    val author: User,
    @ManyToOne
    val topic: Topic,
    val solution: Boolean,
)
