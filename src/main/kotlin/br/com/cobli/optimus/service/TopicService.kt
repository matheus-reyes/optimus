package br.com.cobli.optimus.service
import br.com.cobli.optimus.dto.TopicForm
import br.com.cobli.optimus.dto.TopicView
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

    fun createTopic(topicForm: TopicForm) {
        topics = topics.plus(topicFormMapper.map(topicForm))
    }
}
