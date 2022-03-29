package br.com.cobli.optimus.repository

import br.com.cobli.optimus.dto.TopicByCategoryDto
import br.com.cobli.optimus.model.Topic
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.UUID

interface TopicRepository : JpaRepository<Topic, UUID> {

    fun findByCourseName(courseName: String, pagination: Pageable): Page<Topic>

    @Query("SELECT NEW br.com.cobli.optimus.dto.TopicByCategoryDto(course.category, count(topic)) FROM Topic topic JOIN topic.course course GROUP BY course.category")
    fun getTopicsReport(): List<TopicByCategoryDto>
}
