package br.com.cobli.optimus.service

import br.com.cobli.optimus.model.Course
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CourseService(private final var courses: List<Course>) {

    init {
        val course = Course(
            id = UUID.fromString("262945ed-6af4-4c00-933c-65152a5ae9e7"),
            name = "Kotlin",
            category = "Technology",
        )
        courses = listOf(course)
    }

    fun getCourseById(id: UUID): Course {
        return courses.stream().filter { course ->
            course.id == id
        }.findFirst().get()
    }

}
