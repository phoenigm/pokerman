package ru.phoenigm.pokerman.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class PokermanApplication

fun main(args: Array<String>) {
    runApplication<PokermanApplication>(*args)
}
