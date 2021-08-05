package ru.phoenigm.pokerman.holdem.service

import ru.phoenigm.pokerman.holdem.domain.CardDeck
import ru.phoenigm.pokerman.holdem.service.shuffle.DeckShuffleAlgorithm

class CardDeckShuffleMachine(
    private val shuffleAlgorithm: DeckShuffleAlgorithm
) {

    fun shuffle(cardDeck: CardDeck): CardDeck {
        return shuffleAlgorithm.shuffle(cardDeck)
    }
}