package br.com.cobli.optimus.controller

import br.com.cobli.optimus.dto.CreateTopicForm
import br.com.cobli.optimus.dto.TopicView
import br.com.cobli.optimus.dto.UpdateTopicForm
import br.com.cobli.optimus.service.TopicService
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.* // ktlint-disable no-wildcard-imports
import org.springframework.web.util.UriComponentsBuilder
import java.util.UUID
import javax.validation.Valid

@RestController
@RequestMapping("/topics")
class TopicController(private val service: TopicService) {

    @GetMapping
    @Cacheable("topics_cache")
    fun getTopics(
        @RequestParam(required = false) courseName: String?,
        @PageableDefault(size = 5, sort = ["createdAt"], direction = Sort.Direction.DESC) pagination: Pageable,
    ): Page<TopicView> {
        return service.getTopics(courseName, pagination)
    }

    @GetMapping("/{id}")
    fun getTopicById(@PathVariable id: UUID): TopicView {
        return service.getTopicById(id)
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = ["topics_cache"], allEntries = true)
    fun createTopic(
        @RequestBody @Valid topicForm: CreateTopicForm,
        uriBuilder: UriComponentsBuilder,
    ): ResponseEntity<TopicView> {
        val topicView = service.createTopic(topicForm)
        val uri = uriBuilder.path("/topics/${topicView.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicView)
    }

    @PutMapping
    @Transactional
    @CacheEvict(value = ["topics_cache"], allEntries = true)
    fun updateTopic(@RequestBody @Valid topicForm: UpdateTopicForm): ResponseEntity<TopicView> {
        val topicView = service.updateTopic(topicForm)
        return ResponseEntity.ok(topicView)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    @CacheEvict(value = ["topics_cache"], allEntries = true)
    fun deleteTopic(@PathVariable id: UUID) {
        service.deleteTopic(id)
    }
}
