package br.com.cobli.optimus.model

import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.* // ktlint-disable no-wildcard-imports
import kotlin.collections.ArrayList

@Entity
data class Topic(
    @Id
    val id: UUID? = UUID.randomUUID(),
    var title: String,
    var message: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    @ManyToOne
    val course: Course,
    @ManyToOne
    val author: User,
    @Enumerated(value = EnumType.STRING)
    val status: StatusTopic = StatusTopic.NOT_ANSWERED,
    @OneToMany(mappedBy = "topic")
    val answers: List<Answer> = ArrayList(),
)
