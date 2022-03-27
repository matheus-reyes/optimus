package br.com.cobli.optimus.service
import br.com.cobli.optimus.dto.CreateTopicForm
import br.com.cobli.optimus.dto.TopicView
import br.com.cobli.optimus.dto.UpdateTopicForm
import br.com.cobli.optimus.exception.NotFoundException
import br.com.cobli.optimus.mapper.TopicFormMapper
import br.com.cobli.optimus.mapper.TopicViewMapper
import br.com.cobli.optimus.model.Topic
import org.springframework.stereotype.Service
import java.util.UUID
import java.util.stream.Collectors

@Service
class TopicService(
    private var topics: List<Topic> = ArrayList(),
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicFormMapper,
    private val notFoundMessage: String = "Tópico não existe"
) {

    fun getTopics(): List<TopicView> {
        return topics.stream().map {
            topic ->
            topicViewMapper.map(topic)
        }.collect(Collectors.toList())
    }

    fun getTopicById(id: UUID): TopicView {
        val topic = topics.stream().filter { topic ->
            topic.id == id
        }.findFirst().orElseThrow { NotFoundException(notFoundMessage) }
        return topicViewMapper.map(topic)
    }

    fun createTopic(topicForm: CreateTopicForm): TopicView {
        val topic = topicFormMapper.map(topicForm)
        topics = topics.plus(topic)
        return topicViewMapper.map(topic)
    }

    fun updateTopic(topicForm: UpdateTopicForm): TopicView {
        val topic = topics.stream().filter { topic ->
            topic.id == topicForm.id
        }.findFirst().orElseThrow { NotFoundException(notFoundMessage) }
        val createdTopic = Topic(
            id = topicForm.id,
            title = topicForm.title,
            message = topicForm.message,
            author = topic.author,
            course = topic.course,
            answers = topic.answers,
            status = topic.status,
        )
        topics = topics.minus(topic).plus(createdTopic)
        return topicViewMapper.map(createdTopic)
    }

    fun deleteTopic(id: UUID) {
        val topic = topics.stream().filter { topic ->
            topic.id == id
        }.findFirst().orElseThrow { NotFoundException(notFoundMessage) }
        topics = topics.minus(topic)
    }
}
