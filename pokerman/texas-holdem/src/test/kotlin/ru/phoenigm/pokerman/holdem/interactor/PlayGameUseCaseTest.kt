package ru.phoenigm.pokerman.holdem.interactor

import org.junit.jupiter.api.Test

import ru.phoenigm.pokerman.holdem.domain.Player

internal class PlayGameUseCaseTest {

    private val playGameUseCase = PlayGameUseCase()

    @Test
    fun playGame() {
        val players = listOf(
            Player("Azat"),
            Player("Damir"),
            Player("Rinat")
        )
        val gamesNumber = 1000

        val gameResults = (1..gamesNumber).map {
            playGameUseCase.playGame(players)
        }.groupBy {
            it.winner
        }
        gameResults.forEach {
            println("Player ${it.key.name} won ${it.value.size} times")
        }
    }
}