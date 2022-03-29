package br.com.cobli.optimus.service
import br.com.cobli.optimus.dto.CreateTopicForm
import br.com.cobli.optimus.dto.TopicByCategoryDto
import br.com.cobli.optimus.dto.TopicView
import br.com.cobli.optimus.dto.UpdateTopicForm
import br.com.cobli.optimus.exception.NotFoundException
import br.com.cobli.optimus.mapper.TopicFormMapper
import br.com.cobli.optimus.mapper.TopicViewMapper
import br.com.cobli.optimus.repository.TopicRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class TopicService(
    private val topicRepository: TopicRepository,
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicFormMapper,
    private val notFoundMessage: String = "Tópico não existe",
) {

    fun getTopics(
        courseName: String?,
        pagination: Pageable,
    ): Page<TopicView> {
        val topics = if (courseName == null) topicRepository.findAll(pagination)
        else topicRepository.findByCourseName(courseName, pagination)
        return topics.map {
            topic ->
            topicViewMapper.map(topic)
        }
    }

    fun getTopicById(id: UUID): TopicView {
        val topic = topicRepository.findById(id)
            .orElseThrow { NotFoundException(notFoundMessage) }
        return topicViewMapper.map(topic)
    }

    fun createTopic(topicForm: CreateTopicForm): TopicView {
        val topic = topicFormMapper.map(topicForm)
        topicRepository.save(topic)
        return topicViewMapper.map(topic)
    }

    fun updateTopic(topicForm: UpdateTopicForm): TopicView {
        val topic = topicRepository.findById(topicForm.id)
            .orElseThrow { NotFoundException(notFoundMessage) }
        topic.title = topicForm.title
        topic.message = topicForm.message
        return topicViewMapper.map(topic)
    }

    fun deleteTopic(id: UUID) {
        topicRepository.deleteById(id)
    }

    fun getTopicsReport(): List<TopicByCategoryDto> {
        return topicRepository.getTopicsReport()
    }
}
