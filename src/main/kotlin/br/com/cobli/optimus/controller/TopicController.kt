package br.com.cobli.optimus.controller

import br.com.cobli.optimus.model.Course
import br.com.cobli.optimus.model.Topic
import br.com.cobli.optimus.model.User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topics")
class TopicController {

    @GetMapping
    fun getTopics(): List<Topic> {
        val topic = Topic(
            title = "Kotlin Security",
            message = "Great Message",
            course = Course(
                name = "Kotlin",
                category = "Tecnology",
            ),
            author = User(
                name = "Ana",
                email = "ana@email.com",
            ),
        )
        return listOf(topic, topic)
    }
}
