package br.com.cobli.optimus.controller

import br.com.cobli.optimus.dto.TopicDTO
import br.com.cobli.optimus.model.Course
import br.com.cobli.optimus.model.Topic
import br.com.cobli.optimus.model.User
import br.com.cobli.optimus.service.TopicService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/topics")
class TopicController(private val service: TopicService) {

    @GetMapping
    fun getTopics(): List<Topic> {
        return service.getTopics()
    }

    @GetMapping("/{id}")
    fun getTopicById(@PathVariable id: UUID): Topic {
        return service.getTopicById(id)
    }

    @PostMapping
    fun createTopic(@RequestBody topicDTO: TopicDTO) {
        service.createTopic(topicDTO)
    }
}
