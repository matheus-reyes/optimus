package br.com.cobli.optimus.controller

import br.com.cobli.optimus.dto.TopicForm
import br.com.cobli.optimus.dto.TopicView
import br.com.cobli.optimus.service.TopicService
import org.springframework.web.bind.annotation.*
import java.util.*

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
    fun createTopic(@RequestBody topicDTO: TopicForm) {
        service.createTopic(topicDTO)
    }
}
