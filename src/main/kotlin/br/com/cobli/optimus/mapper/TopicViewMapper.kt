package br.com.cobli.optimus.mapper

import br.com.cobli.optimus.dto.TopicView
import br.com.cobli.optimus.model.Topic
import org.springframework.stereotype.Component

@Component
class TopicViewMapper : Mapper<Topic, TopicView> {

    override fun map(t: Topic): TopicView {
        return TopicView(
            id = t.id,
            title = t.title,
            message = t.message,
            createdAt = t.createdAt,
            status = t.status,
        )
    }
}
