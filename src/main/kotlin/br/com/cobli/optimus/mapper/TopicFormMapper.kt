package br.com.cobli.optimus.mapper

import br.com.cobli.optimus.dto.TopicForm
import br.com.cobli.optimus.model.Topic
import br.com.cobli.optimus.service.CourseService
import br.com.cobli.optimus.service.UserService
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class TopicFormMapper(
    private val courseService: CourseService,
    private val userService: UserService,
) : Mapper<TopicForm, Topic> {

    override fun map(t: TopicForm): Topic {
        return Topic(
            id = UUID.randomUUID(),
            title = t.title,
            message = t.message,
            course = courseService.getCourseById(t.courseId),
            author = userService.getUserById(t.authorId),
        )
    }
}
