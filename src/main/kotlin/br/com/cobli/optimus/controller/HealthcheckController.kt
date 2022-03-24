package br.com.cobli.optimus.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/healthcheck")
class HealthcheckController {

    @GetMapping
    fun healthcheck(): String {
        return "healthy"
    }
}
