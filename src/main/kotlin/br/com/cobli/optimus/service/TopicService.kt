package br.com.cobli.optimus.service
import br.com.cobli.optimus.dto.TopicDTO
import br.com.cobli.optimus.model.Topic
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class TopicService(
        private var topics: List<Topic> = ArrayList(),
        private val courseService: CourseService,
        private val userService: UserService,
) {

    fun getTopics(): List<Topic> {
        return topics
    }

    fun getTopicById(id: UUID): Topic {
        return topics.stream().filter { topic ->
            topic.id == id
        }.findFirst().get()
    }

    fun createTopic(topicDTO: TopicDTO) {
        topics = topics.plus(Topic(
            id = UUID.randomUUID(),
            title = topicDTO.title,
            message = topicDTO.message,
            course = courseService.getCourseById(topicDTO.courseId),
            author = userService.getUserById(topicDTO.authorId),
        ))
    }

}
