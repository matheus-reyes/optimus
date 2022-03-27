package br.com.cobli.optimus.controller

import br.com.cobli.optimus.dto.TopicForm
import br.com.cobli.optimus.dto.TopicView
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
    fun createTopic(@RequestBody @Valid topicDTO: TopicForm) {
        service.createTopic(topicDTO)
    }
}
