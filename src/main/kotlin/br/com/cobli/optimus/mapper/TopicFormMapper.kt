package br.com.cobli.optimus.mapper

import br.com.cobli.optimus.dto.CreateTopicForm
import br.com.cobli.optimus.model.Topic
import br.com.cobli.optimus.service.CourseService
import br.com.cobli.optimus.service.UserService
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class TopicFormMapper(
    private val courseService: CourseService,
    private val userService: UserService,
) : Mapper<CreateTopicForm, Topic> {

    override fun map(t: CreateTopicForm): Topic {
        return Topic(
            id = UUID.randomUUID(),
            title = t.title,
            message = t.message,
            course = courseService.getCourseById(t.courseId),
            author = userService.getUserById(t.authorId),
        )
    }
}
