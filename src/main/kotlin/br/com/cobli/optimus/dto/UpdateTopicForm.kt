package br.com.cobli.optimus.dto

import java.util.UUID
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class UpdateTopicForm(
    @field:NotNull(message = "id cannot be empty")
    val id: UUID,
    @field:NotEmpty(message = "title cannot be empty")
    @field:Size(min = 5, max = 100, message = "title must be between 5 and 100 characters")
    val title: String,
    @field:NotEmpty(message = "message cannot be empty")
    val message: String,
)
