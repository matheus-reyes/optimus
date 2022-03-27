package br.com.cobli.optimus.dto

import java.util.UUID
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class TopicForm (
        @field:NotEmpty @field:Size(min = 5, max = 100) val title : String,
        @field:NotEmpty val message: String,
        @field:NotNull val courseId: UUID,
        @field:NotNull val authorId: UUID,
)
