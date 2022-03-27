package br.com.cobli.optimus.controller

import br.com.cobli.optimus.dto.CreateTopicForm
import br.com.cobli.optimus.dto.TopicView
import br.com.cobli.optimus.dto.UpdateTopicForm
import br.com.cobli.optimus.service.TopicService
import org.springframework.web.bind.annotation.* // ktlint-disable no-wildcard-imports
import java.util.UUID
import javax.validation.Valid

@RestController
@RequestMapping("/topics")
class TopicController(private val service: TopicService) {

    @GetMapping
    fun getTopics(): List<TopicView> {
        return service.getTopics()
    }

    @GetMapping("/{id}")
    fun getTopicById(@PathVariable id: UUID): TopicView {
        return service.getTopicById(id)
    }

    @PostMapping
    fun createTopic(@RequestBody @Valid topicForm: CreateTopicForm) {
        service.createTopic(topicForm)
    }

    @PutMapping
    fun updateTopic(@RequestBody @Valid topicForm: UpdateTopicForm) {
        service.updateTopic(topicForm)
    }

    @DeleteMapping("/{id}")
    fun deleteTopic(@PathVariable id: UUID) {
        service.deleteTopic(id)
    }
}
