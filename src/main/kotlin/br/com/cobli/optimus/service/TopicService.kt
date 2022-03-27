package br.com.cobli.optimus.service
import br.com.cobli.optimus.dto.CreateTopicForm
import br.com.cobli.optimus.dto.TopicView
import br.com.cobli.optimus.dto.UpdateTopicForm
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
        }.findFirst().get()
        return topicViewMapper.map(topic)
    }

    fun createTopic(topicForm: CreateTopicForm) {
        topics = topics.plus(topicFormMapper.map(topicForm))
    }

    fun updateTopic(topicForm: UpdateTopicForm) {
        val topic = topics.stream().filter { topic ->
            topic.id == topicForm.id
        }.findFirst().get()
        topics = topics.minus(topic).plus(
            Topic(
                id = topicForm.id,
                title = topicForm.title,
                message = topicForm.message,
                author = topic.author,
                course = topic.course,
                answers = topic.answers,
                status = topic.status,
            )
        )
    }

    fun deleteTopic(id: UUID) {
        val topic = topics.stream().filter { topic ->
            topic.id == id
        }.findFirst().get()
        topics = topics.minus(topic)
    }
}
