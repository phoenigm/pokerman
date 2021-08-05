package ru.phoenigm.pokerman.holdem.interactor

import ru.phoenigm.pokerman.core.domain.*
import ru.phoenigm.pokerman.core.rules.CardDeckShuffleMachine
import ru.phoenigm.pokerman.core.rules.CombinationDeterminer
import ru.phoenigm.pokerman.core.rules.WinnerDeterminer
import ru.phoenigm.pokerman.core.rules.factory.CardDeckFactory
import ru.phoenigm.pokerman.core.rules.shuffle.SattoloDeckShuffleAlgorithm

class PlayGameUseCase {
    private val cardDeskShuffleMachine = CardDeckShuffleMachine(SattoloDeckShuffleAlgorithm())
    private val deckFactory = CardDeckFactory()
    private val combinationDeterminer = CombinationDeterminer()
    private val winnerDeterminer = WinnerDeterminer()

    fun playGame(players: List<Player>): GameResult {
        val cardDeck = cardDeskShuffleMachine.shuffle(deckFactory.createNewCardDeck())
        val playerToHandMapper = players.map { it to Hand(giveCard(cardDeck), giveCard(cardDeck)) }
            .map {
                println("${it.first.name}: ${it.second}")
                it
            }
        println("******************")
        print("* ")
        val board = (1..5).map { giveCard(cardDeck) }
            .map {
                print("$it ")
                it
            }
        println("*")
        println("******************")

        val playerToCombination = playerToHandMapper.map {
            it.first to HandAndBoard(board + it.second.firstCard + it.second.secondCard)
        }.map {
            it.first to combinationDeterminer.determineCombination(it.second)
        }
        return winnerDeterminer.determine(playerToCombination).let {
            GameResult(it.first, it.second)
        }.also {
            println("Winner: ${it.winner.name} (${it.combination.combinationCategory}) ${it.combination.cards}")
        }
    }

    private fun giveCard(deck: CardDeck): Card {
        return deck.cards.removeAt(deck.cards.size - 1)

    }
}

data class GameResult(val winner: Player, val combination: Combination)