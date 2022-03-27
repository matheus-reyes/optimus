package br.com.cobli.optimus.service
import br.com.cobli.optimus.dto.TopicForm
import br.com.cobli.optimus.dto.TopicView
import br.com.cobli.optimus.model.Topic
import org.springframework.stereotype.Service
import java.util.UUID
import java.util.stream.Collectors

@Service
class TopicService(
        private var topics: List<Topic> = ArrayList(),
        private val courseService: CourseService,
        private val userService: UserService,
) {

    fun getTopics(): List<TopicView> {
        return topics.stream().map { topic -> TopicView(
            id = topic.id,
            title = topic.title,
            message = topic.message,
            createdAt = topic.createdAt,
            status = topic.status,
        )}.collect(Collectors.toList())
    }

    fun getTopicById(id: UUID): TopicView {
        val topic = topics.stream().filter { topic ->
            topic.id == id
        }.findFirst().get()
        return TopicView(
            id = topic.id,
            title = topic.title,
            message = topic.message,
            createdAt = topic.createdAt,
            status = topic.status,
        )
    }

    fun createTopic(topicDTO: TopicForm) {
        topics = topics.plus(Topic(
            id = UUID.randomUUID(),
            title = topicDTO.title,
            message = topicDTO.message,
            course = courseService.getCourseById(topicDTO.courseId),
            author = userService.getUserById(topicDTO.authorId),
        ))
    }

}
