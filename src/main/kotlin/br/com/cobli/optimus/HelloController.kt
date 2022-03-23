package br.com.cobli.optimus

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/healthcheck")
class HelloController {

    @GetMapping
    fun healthcheck(): String {
        return "healthy"
    }
}
