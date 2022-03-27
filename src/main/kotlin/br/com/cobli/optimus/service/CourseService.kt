package br.com.cobli.optimus.service

import br.com.cobli.optimus.model.Course
import br.com.cobli.optimus.repository.CourseRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CourseService(private val courseRepository: CourseRepository) {

    fun getCourseById(id: UUID): Course {
        return courseRepository.getById(id)
    }
}
