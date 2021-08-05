package ru.phoenigm.pokerman

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class ChpokerApplication

fun main(args: Array<String>) {
    runApplication<ChpokerApplication>(*args)
}
