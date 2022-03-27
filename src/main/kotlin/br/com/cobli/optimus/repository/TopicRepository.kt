package br.com.cobli.optimus.repository

import br.com.cobli.optimus.model.Topic
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface TopicRepository : JpaRepository<Topic, UUID>
