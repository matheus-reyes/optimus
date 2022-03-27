package br.com.cobli.optimus.repository

import br.com.cobli.optimus.model.Course
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface CourseRepository : JpaRepository<Course, UUID>
