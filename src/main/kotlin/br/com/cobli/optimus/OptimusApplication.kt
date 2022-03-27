package br.com.cobli.optimus

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class OptimusApplication

fun main(args: Array<String>) {
    runApplication<OptimusApplication>(*args)
}
